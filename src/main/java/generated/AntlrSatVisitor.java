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
	 * Visit a parse tree produced by {@link AntlrSatParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(AntlrSatParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrSatParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(AntlrSatParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrSatParser#create}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate(AntlrSatParser.CreateContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrSatParser#pause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPause(AntlrSatParser.PauseContext ctx);
}