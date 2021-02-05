// Generated from AntlrSat.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AntlrSatParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AntlrSatVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AntlrSatParser#spawn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpawn(AntlrSatParser.SpawnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrSatParser#pause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPause(AntlrSatParser.PauseContext ctx);
}