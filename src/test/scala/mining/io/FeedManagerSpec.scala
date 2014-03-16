package mining.io

import java.io.File
import java.nio.file.FileSystems
import org.scalatest.BeforeAndAfterAll
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FeedManagerSpec extends FunSuite 
                   	  with ShouldMatchers 
                   	  with BeforeAndAfterAll {

  var fmPath: String = null

  override def beforeAll = {
    val sep = FileSystems.getDefault().getSeparator() 
    val tmpPath = List(new File(".").getCanonicalPath(), "tmp", "fm") mkString(sep)
    val tmpFolder = new File(tmpPath)
    if (!tmpFolder.exists())
      tmpFolder.mkdir()

    System.setProperty("mining.feedmgr.path", tmpPath)
    fmPath = tmpPath + sep + SerFeedManager.SER_FEED_MANAGER_NAME
    
    //clean up the feed manager file
    val fmFile = new File(fmPath)
    if (fmFile.exists())
      fmFile.delete()
  }
  
  test("SerFeedManager should be able to store feed descriptor") {
	val sfm = SerFeedManager()
    val fd = sfm.createOrGetFeedDescriptor("http://coolshell.cn/feed")
    sfm.saveFeedDescriptors()
  
    new File(fmPath).exists() should be (true)
  }
  
  test("SerFeedManager should be able to load feed descriptor and get descriptor from URL") {
    val feedUrl = "http://coolshell.cn/feed"
    val sfm = SerFeedManager()
    sfm.feedsMap.values.size should be (1) 
    sfm.loadDescriptorFromUrl(feedUrl).get.feedUrl should be (feedUrl)
  }

  test("FeedManager should be able to parse single url") {
    
  }
  
  test("FeedManager should be able to parse opml format") {
    
  }
  
 
}