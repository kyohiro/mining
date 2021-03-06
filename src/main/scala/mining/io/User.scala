package mining.io

//options:{"folderClose":{},"nav":true,"expanded":false,"mode":"all","sort":"newest","hideEmpty":false,"scrollRead":false}
case class User(userId: Long,
                email: String,
                sort: String,
                display: String,
                hideEmpty: String)

case class ReadStory(userId: Long,
                     storyId: Long,
                     storyLink: String,
                     star: Boolean,
                     read: String
    ){
  //star: "STAR" | ""
  //read: "MARK" | "READ" | "UNREAD"
  //if an entry is not in ReadStory then it's *definitely* unread
  //if an entry is marked as unread, it is different from unread mentioned above
}


object UserFactory {
  def newUser(userId: Long, email: String) = User(userId, email, "", "", "")
}