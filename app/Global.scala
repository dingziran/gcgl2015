import java.io.PrintWriter
import models.Database
import org.squeryl.PrimitiveTypeMode._
import play.api.GlobalSettings
import play.api.Application
import play.api.db.DB
import org.squeryl.{Session,SessionFactory}
import org.squeryl.adapters.MySQLAdapter
import scala.Some

/**
 * Created with IntelliJ IDEA.
 * User: dingziran
 * Date: 13-12-8
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
object Global extends GlobalSettings{
  override def onStart(app:Application){
    SessionFactory.concreteFactory=Some(()=>Session.create(DB.getConnection()(app), new MySQLAdapter ))
    inTransaction{
      val pw=new PrintWriter("DDL.txt")
      Database.printDdl(pw)
      pw.close()
    }
  }

}
