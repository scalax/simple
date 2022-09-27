import Settings._
import ProjectKeys._

forTest.collect

crossDepts += (crossProjectPlatform.value, projectID.value)

enablePlugins(GitVersioning)

git.useGitDescribe := true
