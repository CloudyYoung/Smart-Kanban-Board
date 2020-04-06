package structure;

import com.google.gson.annotations.*;

/**
 * The {@code Board} class, extends from {@code Node}.
 *
 * <p>The instance should contains {@code Column} object as children nodes.
 *
 * @since 1.0
 * @version 2.1
 */
public final class Board extends Node {

  /** Color of the board, in HEX. */
  @Expose private String color;

  /**
   * Constructor of {@code Board}, provide {@code HttpBody}.
   *
   * @param obj the {@code HttpBody} for initialization
   */
  public Board(final HttpBody obj) {
    super(obj);
    this.color = obj.getString("color");
  }

  /**
   * Constructor of {@code Board}, provide title, note and color.
   *
   * @param title The title in {@code String}
   * @param note The note in {@code String}
   * @param boardId THe id in {@code String}
   */
  public Board(
      final int boardId,
      final String title,
      final String note,
      final String color,
      final Node parent) { // NOPMD by 25985 on 2020-04-06, 9:26 a.m.
    super(boardId, title, note, parent);
    this.setColorLocal(color);
  }

  /**
   * Sets the color of the board, in local storage.
   *
   * @param color The color in {@code String}
   */
  public void setColorLocal(final String color) {
    this.color = color;
  }

  /**
   * Sets the color of the board.
   *
   * @param color The color in {@code String}
   * @return the http request of this action
   */
  public HttpRequest setColor(final String color) {
    final HttpRequest req = this.set("color", color);
    if (req.isSucceeded()) {
      this.setColorLocal(color);
    }
    return req;
  }

  /**
   * Returns the color of the board.
   *
   * @return color in {@code String}
   */
  public String getColor() {
    return this.color;
  }

  /**
   * A string that "textually represents" this object.
   *
   * @return text
   */
  public String toString() {
    return this.getType()
        + " (id: "
        + this.getId()
        + ", title: \""
        + this.getTitle()
        + "\", note: \""
        + this.getNote()
        + "\", color: "
        + this.getColor()
        + ", nodes: "
        + this.getChildrenNodes().toString()
        + "\")";
  }
}
