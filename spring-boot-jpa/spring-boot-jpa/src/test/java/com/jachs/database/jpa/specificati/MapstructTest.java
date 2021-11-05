package com.jachs.database.jpa.specificati;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jpa.SpringBootJpaApplication;
import com.jachs.database.jpa.dao.oto.StudentJpaSpecificationExecutorRepository;
import com.jachs.database.jpa.entity.oto.Student;
import com.jachs.database.jpa.entity.oto.dto.StudentDto;
import com.jachs.database.jpa.entity.oto.mapper.StudentConverter;
import com.jachs.database.jpa.entity.oto.model.StudentModel;
import com.jachs.database.jpa.utill.QueryHelp;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest(classes = SpringBootJpaApplication.class)
public class MapstructTest {
	@Autowired
	private StudentJpaSpecificationExecutorRepository studentJpaSpecificationExecutorRepository;

	private void print(List<StudentModel> smList) {
		for (StudentModel studentModel : smList) {
			System.out.println(studentModel.getStudentName() + "\t" + studentModel.getCardName() + "\t"
					+ studentModel.getCardMonery());
		}
	}

	/***
	 * select s.studentName,sc.cardName,sc.cardMonery from student s</br>
	 * inner join studentcard sc</br>
	 * on s.sCart=sc.cardId</br>
	 * where s.studentName like '%王%'
	 */
	@Test
	public void test1() {
		StudentDto sd = new StudentDto();
		sd.setStudentName("王");

		List<Student> stList = studentJpaSpecificationExecutorRepository
				.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, sd, criteriaBuilder));

		List<StudentModel> smList = StudentConverter.INSTANCE.stuToListModel(stList);

		print(smList);
	}
	//同test1结果一致
	@Test
	public void test2() {
		List<Student> stList = studentJpaSpecificationExecutorRepository.findNameLike("王");

		List<StudentModel> smList = StudentConverter.INSTANCE.stuToListModel(stList);

		print(smList);
	}
}
