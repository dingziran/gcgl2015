package models

import play.api.GlobalSettings
import play.api.Application
import play.api.db.DB
import org.squeryl.{Session}
/**
 * Created with IntelliJ IDEA.
 * User: dingziran
 * Date: 13-12-8
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
object Global extends GlobalSettings{
  override def onStart(app:Application){
    SessionFactory.concreteFactory=Some(()=>Session.create(DB.getConnection()(app), new ))
  }

}
