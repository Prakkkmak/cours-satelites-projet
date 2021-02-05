// Generated from satellite.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link satelliteParser}.
 */
public interface satelliteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link satelliteParser#spawn}.
	 * @param ctx the parse tree
	 */
	void enterSpawn(satelliteParser.SpawnContext ctx);
	/**
	 * Exit a parse tree produced by {@link satelliteParser#spawn}.
	 * @param ctx the parse tree
	 */
	void exitSpawn(satelliteParser.SpawnContext ctx);
	/**
	 * Enter a parse tree produced by {@link satelliteParser#pause}.
	 * @param ctx the parse tree
	 */
	void enterPause(satelliteParser.PauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link satelliteParser#pause}.
	 * @param ctx the parse tree
	 */
	void exitPause(satelliteParser.PauseContext ctx);
}