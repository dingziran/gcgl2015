package controllers

import play.api._
import play.api.mvc._
import play.api.data.{Forms, Form}
import play.api.data.Forms._
import models.User

object Application extends Controller {

  def index = Action {
    Redirect(auth.routes.Login.index)
    //Ok(views.html.auth.login())
    //Ok(views.html.index("Your new application is ready."))
  }
  def help=Action{
    Ok(views.html.index("Your new application is ready."))
  }

}