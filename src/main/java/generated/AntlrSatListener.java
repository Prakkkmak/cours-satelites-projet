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
	 * Enter a parse tree produced by the {@code cmdCreate}
	 * labeled alternative in {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCmdCreate(AntlrSatParser.CmdCreateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmdCreate}
	 * labeled alternative in {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCmdCreate(AntlrSatParser.CmdCreateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cmdPause}
	 * labeled alternative in {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCmdPause(AntlrSatParser.CmdPauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmdPause}
	 * labeled alternative in {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCmdPause(AntlrSatParser.CmdPauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cmdAssign}
	 * labeled alternative in {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCmdAssign(AntlrSatParser.CmdAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmdAssign}
	 * labeled alternative in {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCmdAssign(AntlrSatParser.CmdAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cmdRemove}
	 * labeled alternative in {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCmdRemove(AntlrSatParser.CmdRemoveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmdRemove}
	 * labeled alternative in {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCmdRemove(AntlrSatParser.CmdRemoveContext ctx);
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