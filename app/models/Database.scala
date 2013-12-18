package models

import org.squeryl.{Table, Schema}
import org.squeryl.PrimitiveTypeMode._

/**
 * Created with IntelliJ IDEA.
 * User: dingziran
 * Date: 13-12-9
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
object Database extends Schema{
  val usersTable: Table[User] = table[User]("users")

  on(usersTable) { u => declare (
    u.id is(autoIncremented)
  )}


}
