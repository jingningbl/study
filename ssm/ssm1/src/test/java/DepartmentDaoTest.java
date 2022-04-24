import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm1.dao.DepartmentDao;
import com.ssm1.dto.requestDto.DepartmentListRequestDto;
import com.ssm1.dto.responseDto.DepartmentListResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: bai
 * @date: 2022/4/24 10:09
 * @description:
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class DepartmentDaoTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void queryPageList() {
        QueryWrapper<DepartmentListRequestDto> wrapper = new QueryWrapper<>();
        //name like %测试%
        wrapper.like("name", "测试");
        wrapper.eq("status",1);
        Page<DepartmentListRequestDto> page = new Page<>(1,10);
        IPage<DepartmentListResponseDto> iPage = departmentDao.queryPageList(page, wrapper);
//        System.out.println(iPage.getPages());
        System.out.println(iPage);
    }
}