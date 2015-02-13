package consul.v1

import consul.v1.common.ConsulIdentifier
import play.api.libs.json.Json

package object acl {
  trait Acl
  type AclId = ConsulIdentifier[Acl]

  case class AclCreate(Name:String,Type:String,Rules:String)
  case class AclUpdate(ID:AclId,Name:Option[String],Type:Option[String],Rules:Option[String])
  case class AclIdResponse(ID:AclId)
  case class AclInfo(CreateIndex: Long, ModifyIndex: Long,ID:ConsulIdentifier[Acl],Name:Option[String],Type:Option[String],Rules:Option[String])

  implicit lazy val aclIdResponseReads = Json.reads[AclIdResponse]
  implicit lazy val aclInfoReads = Json.reads[AclInfo]

  implicit lazy val aclCreateWrites = Json.writes[AclCreate]
  implicit lazy val aclUpdateWrites = Json.writes[AclUpdate]


}
