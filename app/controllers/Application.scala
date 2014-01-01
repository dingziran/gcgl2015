package controllers

import play.api._
import play.api.mvc._
import play.api.data.{Forms, Form}
import play.api.data.Forms._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def activities =Action{
      Ok(views.html.activities())
  }
}