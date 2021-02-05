// Generated from AntlrSat.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AntlrSatParser}.
 */
public interface AntlrSatListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AntlrSatParser#spawn}.
	 * @param ctx the parse tree
	 */
	void enterSpawn(AntlrSatParser.SpawnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AntlrSatParser#spawn}.
	 * @param ctx the parse tree
	 */
	void exitSpawn(AntlrSatParser.SpawnContext ctx);
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