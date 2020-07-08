package kr.co.pk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.pk.domain.Item;

@Repository
public class ItemDao {
	@Autowired
	//MyBatis를 xml로 이용할 때 사용하는 클래스
	private SqlSession sqlSession;
	
	//Hibernate는 세션 팩토리
	@Autowired
	private SessionFactory sessionFactory;
	
	//Item 테이블의 전체 데이터를 가져오는 메소드
	public List<Item> allitem(){
		return sqlSession.selectList("item.allitem");
		//return sessionFactory.getCurrentSession().createCriteria(Item.class).list();
	}
	//Item 테이블에서 1개의 데이터를 가져오는 메소드
	public Item detailitem(Integer itemid) {
		return sqlSession.selectOne("item.detailitem", itemid);
		//return sessionFactory.getCurrentSession().get(Item.class, itemid);
	}

}
