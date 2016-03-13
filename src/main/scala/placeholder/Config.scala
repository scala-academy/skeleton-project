package placeholder

import com.typesafe.config.ConfigFactory

import scala.util.Try

trait Config {
  protected lazy val config = ConfigFactory.load()
  protected lazy val exampleHttpConfig = Try(config.getConfig("http").getConfig("exampleserver")).getOrElse(ConfigFactory.empty())
  lazy val exampleHttpInterface = Try(exampleHttpConfig.getString("interface")).getOrElse("0.0.0.0")
  lazy val exampleHttpPort: Int = Try(exampleHttpConfig.getInt("port")).getOrElse(0)
}
