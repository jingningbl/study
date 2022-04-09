import com.dao.SongDao;
import com.dao.SongDaoImpl;
import com.dao.UsDao;
import com.dao.UsDaoImpl;
import com.pojo.Song;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

/**
 * song的测试类
 * @author bai
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2021/12/7 15:46
 * @describe
 */
public class TestSong {
    SongDao songDao=new SongDaoImpl();
    @Test
    public void testSongSave(){
        Song song=new Song(1,"Stuck in","XMASwu",
                "心碎","流行","D://Stuck.mp3",54126, new Timestamp(new Date().getTime()));
        songDao.save(song);
    }
    @Test
    public void testSongDelete(){
        songDao.delete(4);
    }
    @Test
    public void testFindSongById(){
        System.out.println((songDao.findSongById(13)).toString());
    }
    @Test
    public void testFindSongsAll(){
        System.out.println((songDao.findSongsAll(2,3)).toString());
    }
    @Test
    public void testFindSongsSids(){
        UsDao usDao=new UsDaoImpl();
        System.out.println((songDao.findSongsSids(usDao.findSongsAll(1))).toString());;
    }
}
