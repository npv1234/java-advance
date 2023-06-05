package com.vti.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.form.FormGroup;
import com.vti.utils.HibernateUtils;

public class GroupRepository implements IGroupRepository{
	private HibernateUtils hibernateUtils;
	
	public GroupRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	public void addNewGroup(FormGroup formGroup) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			transaction = session.getTransaction();
			
			transaction.begin();
			
			Account ac = session.get(Account.class, formGroup.getCreatorId());
			
			Group group = new Group(
				formGroup.getGroupName(),
				formGroup.getTotalMember(),
				ac,
				formGroup.getCreatedAt()
			);
			session.save(group);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

	
	public List<Group> getListGroups() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Query<Group> query = session.createQuery("FROM Group");
			return query.list();
		}finally {
			if (session != null) {
				session.clear();
			}
		}
	
	}

	public void deleteGroup(int id) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			transaction = session.getTransaction();
			transaction.begin();
			
			Group grp = session.get(Group.class, id);
			session.delete(grp);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateGroup(FormGroup formGroup) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = hibernateUtils.openSession();
			transaction = session.getTransaction();
			transaction.begin();
			
			Group group = session.get(Group.class, formGroup.getId());
			group.setGroupName(formGroup.getGroupName());
			group.setTotalMember(formGroup.getTotalMember());
			group.setCreatedAt(formGroup.getCreatedAt());
			
			Account ac = session.get(Account.class, formGroup.getCreatorId());
			group.setCreator(ac);
			
			session.save(group);
			
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

    public void deleteGroups(List<Integer> ids) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = hibernateUtils.openSession();
            transaction = session.getTransaction();
            transaction.begin();

            String deleteQuery = "DELETE FROM Group grp WHERE grp.id IN(:idsParameter)";
            Query query = session.createQuery(deleteQuery);
            query.setParameter("idsParameter", ids);
            query.executeUpdate();

            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

	

}
