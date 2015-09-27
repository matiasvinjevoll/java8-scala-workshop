package no.bekk.scala.exercises

import java.time.LocalDate

import no.bekk.scala.model.Data.{manchesterUnited, wayneRooney, liverpool}
import no.bekk.scala.model.Team
import org.junit.runner.RunWith
import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.junit.JUnitRunner
@RunWith(classOf[JUnitRunner])
class Ex5_OptionSpec extends FlatSpec with Matchers {

	"Younges player name" should "be present" in {
		val playerName = Ex5_Option.youngestPlayerNameOlderThan(manchesterUnited, LocalDate.of(1986, 1, 1))
		playerName shouldBe Some(wayneRooney.name)
	}

	"Youngest player name" should "not be present" in {
		val playerName = Ex5_Option.youngestPlayerNameOlderThan(liverpool, LocalDate.of(1900, 1, 1))
		playerName shouldBe None
	}

	"Youngest player name" should "not be present when team with no players" in {
		val playerName = Ex5_Option.youngestPlayerNameOlderThan(Team("", 0, Nil), LocalDate.of(2000, 1, 1))
		playerName shouldBe None
	}
}
