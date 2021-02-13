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
	 * Enter a parse tree produced by {@link AntlrSatParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(AntlrSatParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(AntlrSatParser.AssignContext ctx);
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
	 * Enter a parse tree produced by {@link AntlrSatParser#remove}.
	 * @param ctx the parse tree
	 */
	void enterRemove(AntlrSatParser.RemoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#remove}.
	 * @param ctx the parse tree
	 */
	void exitRemove(AntlrSatParser.RemoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrSatParser#speed}.
	 * @param ctx the parse tree
	 */
	void enterSpeed(AntlrSatParser.SpeedContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#speed}.
	 * @param ctx the parse tree
	 */
	void exitSpeed(AntlrSatParser.SpeedContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrSatParser#movement}.
	 * @param ctx the parse tree
	 */
	void enterMovement(AntlrSatParser.MovementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#movement}.
	 * @param ctx the parse tree
	 */
	void exitMovement(AntlrSatParser.MovementContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link AntlrSatParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(AntlrSatParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(AntlrSatParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AntlrSatParser#pos}.
	 * @param ctx the parse tree
	 */
	void enterPos(AntlrSatParser.PosContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#pos}.
	 * @param ctx the parse tree
	 */
	void exitPos(AntlrSatParser.PosContext ctx);
}