// Generated from satellite.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link satelliteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface satelliteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link satelliteParser#spawn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpawn(satelliteParser.SpawnContext ctx);
	/**
	 * Visit a parse tree produced by {@link satelliteParser#pause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPause(satelliteParser.PauseContext ctx);
}