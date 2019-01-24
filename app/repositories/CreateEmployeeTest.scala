
import slick.basic.DatabaseConfig
import slick.dbio.{DBIOAction, Effect}
import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.api._
import slick.sql.{FixedSqlAction, FixedSqlStreamingAction}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration


case class Employee(id:Int, name:String, designation:String)

class UserTableDef(tag: Tag) extends Table[Employee](tag, "Employee") {

  def id = column[Int]("id", O.PrimaryKey,O.AutoInc)
  def name = column[String]("name")
  def designation = column[String]("designation")

  override def * =
    (id, name, designation) <>(Employee.tupled, Employee.unapply)
}


object CreateEmployeeTest extends App {
  val db = Database.forConfig("db")


  val employee = TableQuery[UserTableDef]
   //Await.result(db.run(DBIOAction.seq(employee.schema.create)),Duration.Inf)
val result: FixedSqlStreamingAction[Seq[Employee], Employee, Effect.Read] = employee.result
  Await.result(db.run(DBIOAction.seq(result)),Duration.Inf)

//  val result1: FixedSqlAction[Int, NoStream, Effect.Write] = employee.insertOrUpdate(Employee(23,"sherwin","manager"))
//
//  Await.result(db.run(result1),Duration.Inf)


//  employee += Employee(23,"sherwin","Manager")
//  Await.result(db.run(DBIOAction.seq(employee.result)),Duration.Inf)
  db.close()

}