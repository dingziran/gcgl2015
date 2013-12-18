package models

import org.squeryl.{Query, KeyedEntity}
import org.squeryl.PrimitiveTypeMode._

/**
 * Created with IntelliJ IDEA.
 * User: dingziran
 * Date: 13-12-8
 * Time: 下午2:22
 * To change this template use File | Settings | File Templates.
 */
case class User(
  id:Long,
  username:String,
  password:String) extends KeyedEntity[Long]

object User{

  import Database._

  def allQ: Query[User]= from(usersTable){
    user => select(user) orderBy(user.username desc)
  }

  def findAll: Iterable[User] = inTransaction{
    allQ.toList
  }
  def insert(user:User):User=inTransaction{
    usersTable.insert(user)
  }

  def find(name:String):User = inTransaction{
    from(usersTable){
      user => where(user.username===name) select(user)
    }.single
  }

  def delete(user:User)=inTransaction{
    usersTable.delete(user.id)
  }



}