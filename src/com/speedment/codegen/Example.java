package com.speedment.codegen;

import com.speedment.codegen.base.CodeGenerator;
import com.speedment.codegen.java.JavaGenerator;
import com.speedment.codegen.java.controller.AutoJavadoc;
import com.speedment.codegen.java.controller.SetGet;
import com.speedment.codegen.java.models.Class;
import com.speedment.codegen.java.models.Field;
import com.speedment.codegen.java.models.Method;
import com.speedment.codegen.java.models.Type;
import static com.speedment.codegen.java.models.constants.Default.*;
import static com.speedment.codegen.Formatting.*;
import com.speedment.codegen.java.controller.FinalParameters;
import com.speedment.codegen.java.models.Javadoc;
import com.speedment.codegen.java.models.Import;
import com.speedment.codegen.java.models.EnumConstant;
import com.speedment.codegen.java.models.Enum;
import com.speedment.codegen.java.models.Interface;
import com.speedment.codegen.java.models.values.EnumValue;
import com.speedment.codegen.java.models.values.NumberValue;
import com.speedment.codegen.java.models.values.ReferenceValue;
import com.speedment.codegen.java.models.values.TextValue;
import java.time.LocalDate;

/**
 *
 * @author Emil Forslund
 */
public class Example {
	private Example() {}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		final CodeGenerator cg = new JavaGenerator();
		
		Formatting.tab("    ");
		
		LocalDate t = LocalDate.now();
		LocalDate t2 = LocalDate.now().plus(null);
		//Duration.ofDays(7)
		
		final Type typeThread  = new Type(Thread.class);
		final Type spriteStore = new Type("org.duncan.test.SpriteStore");
		final Type soundStore  = new Type("org.duncan.test.SoundStore");
		
		Enum myEnum;
		System.out.println(cg.on(myEnum = new Enum("org.duncan.util.Card")
				.public_()
					
				.add(new EnumConstant("HEART_OF_ACE")
					.add(new NumberValue(1))
					.add(new TextValue("♥"))
				)
				.add(new EnumConstant("HEART_OF_SPADES")
					.add(new NumberValue(1))
					.add(new TextValue("♠"))
				)
				.add(new EnumConstant("HEART_OF_CLUBS")
					.add(new NumberValue(1))
					.add(new TextValue("♣"))
				)
				.add(new EnumConstant("HEART_OF_DIAMONDS")
					.add(new NumberValue(1))
					.add(new TextValue("♦"))
				)
			).get() + "\n"
		);
		
		System.out.println(cg.on(new Interface("org.duncan.test.Player")
				/***** Class declaration *****/
				.public_()
				.setJavadoc(new Javadoc(
					"This is a test class to demonstrate how the\n" +
					"code generator is working."
				))
					
				/***** Fields *****/
				.add(new Field("cards", list(myEnum.asType()))
					.private_().final_().static_()
					.setValue(new ReferenceValue("new ArrayList<>()"))
				)
				.add(new Field("primitiveCards", myEnum.asType().setArrayDimension(2))
					.private_().final_().static_()
					.setValue(new ReferenceValue("new Card() [4][13]"))
				)
				.add(new Field("favoriteCard", myEnum.asType())
					.private_().final_()
					.setValue(new EnumValue(myEnum.asType(), "HEART_OF_ACE"))
				)	
					
				/***** Methods *****/
				.add(new Method("spawn", VOID)
					.setJavadoc(new Javadoc(
						"This function is used to reset the Player."
					))
					.add(new Field("name", STRING))
					.add(new Field("score", INT_PRIMITIVE))
				)
			).get() + "\n"
		);
		
		System.out.println(cg.on(new Class("org.duncan.test.MittTest", typeThread)
				/***** Dependencies *****/
				.add(new Import(LIST))
				
				/***** Class declaration *****/
				.public_()
				.setJavadoc(new Javadoc(
					"This is a test class to demonstrate how the\n" +
					"code generator is working."
				))
				
				/***** Fields *****/
				.add(new Field("player1Name", STRING))
				.add(new Field("player2Name", STRING))
				.add(new Field("player1Score", INT_PRIMITIVE))
				.add(new Field("player2Score", INT_PRIMITIVE))
				.add(new Field("players", list(new Type("org.duncan.test.Player"))))
				.add(new Field("spriteStore", spriteStore))
				.add(new Field("soundStore", soundStore))
					
				/***** Methods *****/
				.add(new Method("spawnPlayer1", VOID).public_()
					.setJavadoc(new Javadoc(
						"This function is used to reset Player 1."
					))
					.add(new Field("name", STRING))
					.add(new Field("score", INT_PRIMITIVE))
					.add("this.player1Name = name;")
					.add("this.player1Score = score;")
				)
				.add(new Method("spawnPlayer2", VOID).public_()
					.setJavadoc(new Javadoc(
						"This function is used to reset Player 2."
					))
					.add(new Field("name", STRING))
					.add(new Field("score", INT_PRIMITIVE))
					.add("this.player2Name = name;")
					.add("this.player2Score = score;")
				)
				.add(new Method("killPlayer", VOID).public_()
					.setJavadoc(new Javadoc(
						"This method can be used to kill either player."
					))
					.add(new Field("name", STRING))
					.add("switch (name) " + block(
						"case (this.player1Name) : killPlayer1(); break;",
						"case (this.player2Name) : killPlayer2(); break;"
					))
				)
				.add(new Method("killPlayer1", VOID).protected_()
					.add("this.player2Score += 20;")
				)
				.add(new Method("killPlayer2", VOID).protected_()
					.add("this.player1Score += 20;")
				)
				.add(new Method("restart", VOID).public_()
					.add("spawnPlayer1();")
					.add("spawnPlayer2();")
				)
				
				/***** Controllers *****/
				.call(new SetGet())
				.call(new FinalParameters())
				.call(new AutoJavadoc())
					
			
			).get() + "\n"
		);
	}
	
}
