package net.scalax.simple.codec

object KBCS {

  case class ModelA[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Class[_]], name11: F[String], github: ModelB[F])
  case class ModelB[F[_]](repo: F[String], commits: F[Int], orgName: F[String], folder: ModelC[F])
  case class ModelC[F[_]](fileName: F[String], folderName: F[String], extName: F[String], size: F[Int])

  def from(model: ModelA[ContextI#IdF]): ModelA[ContextI#SimpleVarF] = {
    val modelCImpl = ModelC[ContextI#SimpleVarF](
      fileName = SimpleVar(model.github.folder.fileName),
      folderName = SimpleVar(model.github.folder.folderName),
      extName = SimpleVar(model.github.folder.extName),
      size = SimpleVar(model.github.folder.size)
    )
    val modelBImpl = ModelB[ContextI#SimpleVarF](
      repo = SimpleVar(model.github.repo),
      commits = SimpleVar(model.github.commits),
      orgName = SimpleVar(model.github.orgName),
      folder = modelCImpl
    )
    ModelA[ContextI#SimpleVarF](
      name = SimpleVar(model.name),
      str = SimpleVar(model.str),
      uClass = SimpleVar(model.uClass),
      name11 = SimpleVar(model.name11),
      github = modelBImpl
    )
  }

  def to(model: ModelA[ContextI#SimpleVarF]): ModelA[ContextI#IdF] = {
    val modelCImpl = ModelC[ContextI#IdF](
      fileName = model.github.folder.fileName.value,
      folderName = model.github.folder.folderName.value,
      extName = model.github.folder.extName.value,
      size = model.github.folder.size.value
    )
    val modelBImpl = ModelB[ContextI#IdF](
      repo = model.github.repo.value,
      commits = model.github.commits.value,
      orgName = model.github.orgName.value,
      folder = modelCImpl
    )
    ModelA[ContextI#IdF](
      name = model.name.value,
      str = model.str.value,
      uClass = model.uClass.value,
      name11 = model.name11.value,
      github = modelBImpl
    )
  }

  def main(arr: Array[String]): Unit = {
    val modelC: ModelC[ContextI#IdF] = ModelC[ContextI#IdF](fileName = "xxuuw", folderName = "5ua", extName = ".txt", size = 7)
    val modelB: ModelB[ContextI#IdF] = ModelB[ContextI#IdF](repo = "xxuuw", commits = 2, orgName = "scalax", folder = modelC)
    val modelA: ModelA[ContextI#IdF] =
      ModelA[ContextI#IdF](name = 2, str = Option.empty, uClass = this.getClass, name11 = "xxuu", github = modelB)

    val setting = from(modelA)
    setting.github.folder.fileName.value = "Now File Value"
    setting.github.commits.value = 115415
    setting.str.value = Option("22" * 20)
    val newModelA = to(setting)

    println(modelA)
    println(newModelA)
  }

}
