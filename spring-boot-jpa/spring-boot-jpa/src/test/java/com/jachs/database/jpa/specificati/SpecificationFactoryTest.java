package com.jachs.database.jpa.specificati;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.jachs.database.jpa.dao.oto.StudentJpaSpecificationExecutorRepository;
import com.jachs.database.jpa.entity.oto.Student;
import com.jachs.database.jpa.utill.SpecificationFactory;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class SpecificationFactoryTest {
	@Autowired
	private StudentJpaSpecificationExecutorRepository studentJpaSpecificationExecutor;

	@Test
	public void test() {
		String id1 = "aaVSmUimxabsklZtbnBLaEAYtzqLnmasvKIkwSHeaKdjabRJbwyqCxewoPdysNjHjNgJPbIzQLhkHyZEAbUVpWpDQGZdHLPomdLebgoQbthzWgVUYAtuUeXWWVtONJRcKdecyGGfyzhZzZdiOpWgJzUFTbhxTsMbMatpVNUbnbxjbtBGRFZxallWDEXPJOqTJSUGBqCqfEdCangvKJbWYlTnDpcawJYJAMZHQlzRcFeFvOKcbgHkqJBmOlDToFn";
		String id2 = "akXDoNFJoPpmEpjPIVVPJAKpKUMKHnYFMspwepwOlANDVgJbRcIbhdfPqGxKYyyYfPzMYiGNDusgNQcYEfReZkxRpAfYKipJznODqMFhkiUqwUeURqCgTdyrLExdOkmADeuRPJvwORBxAejnhQBEGeLiAwAHYFRZdFhEtWfsuuojHvERLRlNvVMRQDeWKESoFtWOYFHdXmaBrXSzbqPNXyUUKojWlecGqZGEIIqxTDhzhmuDgKiOQZIkwugZTOP";
		Specification<Student> s1 = new Specification<Student>() {
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {
				Predicate p1 = criteriaBuilder.equal(root.get("studentId"), id1);
				Predicate p2 = criteriaBuilder.equal(root.get("studentId"), id2);
				return criteriaBuilder.or(p1, p2);
			}
		};
		List<Student> stus = studentJpaSpecificationExecutor.findAll(s1);

		System.out.println(stus.size());
	}

	@Test
	public void test1() {
		Student student = new Student();

		student.setDateOfBirth(new Date());
		student.setStudentName("dBjkwFdXWBCbAnVyhqBTyRqCzofoYKSNgQaXmzsurDKTCNJ");
		Specification<Student> systemUserSpecification = (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<Predicate>();
			// 模糊查询
			if (StringUtils.isNoneBlank(student.getStudentName())) {
				predicates.add(cb.like(root.get("studentName"), "%" + student.getStudentName() + "%"));
			}

			// 日期比较
			if (student.getDateOfBirth() != null) {
				predicates
						.add(cb.greaterThanOrEqualTo(root.get("dateOfBirth").as(String.class), "2020-11-21 14:54:42"));
			}

			return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
		};
		List<Student> stus = studentJpaSpecificationExecutor.findAll(systemUserSpecification);

		System.out.println(stus.size());
	}
	/***
	 * select student0_.studentId as studenti1_12_, student0_.dateOfBirth as dateofbi2_12_,
	 *  student0_.studentAge as studenta3_12_, student0_.sCart as scart5_12_, 
	 *  student0_.studentName as studentn4_12_ from Student student0_ 
	 *  where student0_.studentAge<=15 and (student0_.studentName like ?) and
	 *   cast(student0_.dateOfBirth as binary)<1624858146479
	 */
	@Test
	public void test3() {
		Student student = new Student();
		
		student.setStudentAge(15);
		student.setDateOfBirth(new Date());
		student.setStudentName("OrdBUJUZgjxLFIAlypEFtIWWO");
		
		 // 构造条件
	    Specification specification = SpecificationFactory.lt("dateOfBirth", student.getDateOfBirth().getTime());
	    specification = specification.and(SpecificationFactory.like("studentName", student.getStudentName()));
	    specification = specification.and(SpecificationFactory.lte("studentAge", student.getStudentAge()));
	    // 打印结果
	    List<Student> systemUserList = this.studentJpaSpecificationExecutor.findAll(specification);
	    for (Student user : systemUserList) {
	        System.out.println(user);
	    }
	}
}
