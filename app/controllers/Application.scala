package controllers

import play.api._
import play.api.mvc._
import play.api.data.{Forms, Form}
import play.api.data.Forms._
import com.mongodb.casbah.Imports._
import play.api.libs.json.{Json, JsString}

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def activities =Action{
      Ok(views.html.activities())
  }

  def createActivity=Action{ request =>
    val mongoClient= MongoClient()
    val db=mongoClient("gcgl")
    db.collectionNames
    val activities = db("activities")
    val productJson = request.body
   // productJson.asJson.getOrElse(JsNull).
  val p = Json.obj(
  "name"-> JsString("Dingziran")
  )



    //val a = MongoDBObject(p)
    Ok(p.toString())
  }
}