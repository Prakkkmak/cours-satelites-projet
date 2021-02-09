// Generated from AntlrSat.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AntlrSatParser}.
 */
public interface AntlrSatListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AntlrSatParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(AntlrSatParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(AntlrSatParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(AntlrSatParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(AntlrSatParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrSatParser#create}.
	 * @param ctx the parse tree
	 */
	void enterCreate(AntlrSatParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#create}.
	 * @param ctx the parse tree
	 */
	void exitCreate(AntlrSatParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrSatParser#pause}.
	 * @param ctx the parse tree
	 */
	void enterPause(AntlrSatParser.PauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#pause}.
	 * @param ctx the parse tree
	 */
	void exitPause(AntlrSatParser.PauseContext ctx);
}