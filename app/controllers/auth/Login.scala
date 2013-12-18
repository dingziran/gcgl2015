package controllers.auth

import play.api.mvc.{Action, Controller}
import play.api.data.Forms._
import models.User
import play.api.data.{Forms, Form}

/**
 * Created with IntelliJ IDEA.
 * User: dingziran
 * Date: 13-12-7
 * Time: 下午1:33
 * To change this template use File | Settings | File Templates.
 */
object Login extends Controller {

  val userForm=Form(mapping(
    "id"-> Forms.longNumber,
    "username"->Forms.text,
    "password"->Forms.text
  )(User.apply)(User.unapply))

  def index = Action {
    Ok(views.html.auth.login(userForm))
  }
  def login = Action{ request =>

    userForm.bindFromRequest()(request).fold(
      formWithErrors => Ok(views.html.auth.login(formWithErrors)),
      value=>Ok("created: "+value)
    )
  }
}
