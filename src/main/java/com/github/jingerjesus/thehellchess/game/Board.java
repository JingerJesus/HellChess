package com.github.jingerjesus.thehellchess.game;

import com.github.jingerjesus.thehellchess.control.Constants;
import com.github.jingerjesus.thehellchess.control.GameController;
import com.github.jingerjesus.thehellchess.control.UI;


public class Board {
    public Tile[][] tiles = new Tile[16][16];
    public Highlight[][] highlights = new Highlight[16][16];

    public Board() {
        for (int i = 0; i < tiles.length; i ++) {
            for (int j = 0; j < tiles[i].length; j ++) {

                //tilemap init
                tiles[i][j] = new Tile(i * Constants.TILE_SIZE, j * Constants.TILE_SIZE, Constants.NO_PIECE);
                UI.mainGroup.getChildren().add(tiles[i][j].coverView);

                //highlight map init
                highlights[i][j] = new Highlight(i , j,
                        Constants.HighlightType.NONE);
                UI.mainGroup.getChildren().add(highlights[i][j].view);
            }
        }
    }

    public void updateBoard() {

        for (int i = 0; i < tiles.length; i ++) {
            for (int j = 0; j < tiles[i].length; j ++) {

                for (int k = 0; k < GameController.playerOnePieces.size(); k ++) {
                    if (GameController.playerOnePieces.get(k).x == i && GameController.playerOnePieces.get(k).y == j) {
                        tiles[i][j].coverView.setImage(GameController.playerOnePieces.get(k).cover);
                        tiles[i][j].occupiedBy = GameController.playerOnePieces.get(k);
                    }
                }

                for (int k = 0; k < GameController.playerTwoPieces.size(); k ++) {
                    if (GameController.playerTwoPieces.get(k).x == i && GameController.playerTwoPieces.get(k).y == j) {
                        tiles[i][j].coverView.setImage(GameController.playerTwoPieces.get(k).cover);
                        tiles[i][j].occupiedBy = GameController.playerTwoPieces.get(k);
                    }
                }

                for (int k = 0; k < GameController.playerThreePieces.size(); k ++) {
                    if (GameController.playerThreePieces.get(k).x == i && GameController.playerThreePieces.get(k).y == j) {
                        tiles[i][j].coverView.setImage(GameController.playerThreePieces.get(k).cover);
                        tiles[i][j].occupiedBy = GameController.playerThreePieces.get(k);
                    }
                }
            }
        }
    }

    public void updateHighlights(Tile selectedTile) {
        if (selectedTile != null) {
            highlights[selectedTile.x][selectedTile.y].setHighlight(Constants.HighlightType.SELECTED);
        } else {
            for (int i = 0; i < highlights.length; i ++) {
                for (int j = 0; j < highlights.length; j ++) {
                    highlights[i][j].setHighlight(Constants.HighlightType.NONE);
                }
            }
        }
    }

    public void selectTile(Tile tile) {

    }

    public Piece pieceAt(int x, int y) {
        if (this.tiles[x][y].occupiedBy.equals(Constants.NO_PIECE))
            System.out.println("No Piece Here");
        return this.tiles[x][y].occupiedBy;
    }

    /*
    public Tile getTileClicked(int mouseX, int mouseY) {
        for (int i = 0; i < this.tiles.length; i ++) {
            for (int j = 0; j < this.tiles.length; j ++) {
                if (mouseX > i * Constants.TILE_SIZE && mouseX < (i + 1) * Constants.TILE_SIZE) {
                    if (mouseY > j * Constants.TILE_SIZE && mouseY < (j + 1) * Constants.TILE_SIZE) {
                        return this.tiles[i][j];
                    }
                }
            }
        }
        return null;
    }
    */

}
