package models

/**
 * Created with IntelliJ IDEA.
 * User: dingziran
 * Date: 13-12-8
 * Time: 下午2:22
 * To change this template use File | Settings | File Templates.
 */
case class User(id:Long, username:String,password:String)

object User{
  def all(): List[User] = Nil

  def create(label: String) {}

  def delete(id: Long) {}
}
