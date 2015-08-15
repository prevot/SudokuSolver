import Sudoku

public class SudokuTest extends GroovyTestCase 
{   
    void test1()
    {
        def g= [[0, 0, 0, 0, 0, 0, 6, 0, 0],
                [0, 1, 0, 0, 0, 2, 8, 0, 3],
                [0, 9, 0, 0, 5, 8, 0, 0, 0],
                [0, 3, 0, 0, 0, 0, 7, 0, 4],
                [6, 2, 0, 7, 8, 0, 0, 0, 0],
                [5, 0, 0, 0, 6, 3, 0, 0, 0],
                [4, 0, 0, 0, 9, 5, 0, 0, 0],
                [0, 7, 0, 8, 0, 0, 5, 0, 0],
                [2, 0, 0, 0, 3, 0, 9, 8, 0]] as int[][] 
                
       Sudoku sudo =  Sudoku.calcul_global(g,false)
       
       assert sudo.modifArbitraire.size() == 0  : "Le système n'a pas de modification arbitraire à faire (${sudo.modifArbitraire})"
       assert sudo.checkGrille()                : "Le système aurait dû être capable de résoudre cette grille !!!"
       assert !sudo.tropDeValeursForcees()      : "Le système n'aurait pas dû forcer autant de valeurs !!!!"
       assert sudo.complexiteGrille == 6        : "Le calcul de la complexité est faux (bonne valeur ${sudo.complexiteGrille})"

    }
    void test2()
    {
       def g= [[2, 0, 0, 0, 0, 5, 8, 6, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 7, 4, 2, 8, 0, 0, 9],[0, 0, 9, 0, 0, 0, 1, 7, 2],[0, 0, 0, 0, 0, 0, 6, 0, 0],[6, 2, 0, 3, 9, 0, 4, 0, 0],[0, 0, 0, 0, 1, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 8, 0],[1, 0, 4, 7, 0, 0, 5, 0, 0]] as int[][]               
       Sudoku sudo =  Sudoku.calcul_global(g,false)
       
       assert sudo.modifArbitraire.size() == 0  : "Le système n'a pas de modification arbitraire à faire (${sudo.modifArbitraire})"
       assert sudo.checkGrille()                : "Le système aurait dû être capable de résoudre cette grille !!!"
       assert !sudo.tropDeValeursForcees()      : "Le système n'aurait pas dû forcer autant de valeurs !!!!"
       assert sudo.complexiteGrille == 9        : "Le calcul de la complexité est faux (bonne valeur ${sudo.complexiteGrille})"
    }
    void test3()
    {
       def g= [[0, 9, 0, 0, 0, 4, 0, 0, 0],[0, 0, 0, 0, 8, 0, 1, 0, 4],[5, 0, 0, 0, 3, 0, 0, 0, 0],[0, 0, 0, 0, 2, 8, 3, 0, 1],[0, 1, 4, 0, 0, 6, 0, 0, 0],[6, 0, 0, 0, 0, 0, 7, 0, 0],[0, 2, 7, 0, 0, 0, 0, 0, 8],[0, 0, 0, 0, 0, 0, 2, 0, 0],[3, 0, 0, 0, 4, 0, 0, 5, 0]] as int[][]
       Sudoku sudo =  Sudoku.calcul_global(g,false)
       
       assert sudo.modifArbitraire.size() != 0  : "Le système a des modifications arbitraires à faire"
       assert !sudo.checkGrille()               : "Le système n'aurait pas dû être capable de résoudre cette grille !!!"
       assert sudo.tropDeValeursForcees()       : "Le système n'aurait pas dû forcer autant de valeurs !!!!"
       assert sudo.complexiteGrille == 17       : "Le calcul de la complexité est faux (bonne valeur ${sudo.complexiteGrille})"
    }
    void test4()
    {
       def g= [[8, 9, 2, 0, 0, 4, 0, 0, 0],[0, 0, 0, 0, 8, 0, 1, 0, 4],[5, 0, 0, 0, 3, 0, 0, 0, 0],[0, 0, 0, 0, 2, 8, 3, 0, 1],[0, 1, 4, 0, 0, 6, 0, 0, 0],[6, 0, 0, 0, 0, 0, 7, 0, 0],[0, 2, 7, 0, 0, 0, 0, 0, 8],[0, 0, 0, 0, 0, 0, 2, 0, 0],[3, 0, 0, 0, 4, 0, 0, 5, 0]] as int[][]
       Sudoku sudo =  Sudoku.calcul_global(g,false)
       
       assert sudo.modifArbitraire.size() == 0  : "Le système n'a pas de modification arbitraire à faire (${sudo.modifArbitraire})"
       assert sudo.checkGrille()                : "Le système aurait dû être capable de résoudre cette grille !!!"
       assert !sudo.tropDeValeursForcees()      : "Le système n'aurait pas dû forcer autant de valeurs !!!!"
       assert sudo.complexiteGrille == 8        : "Le calcul de la complexité est faux (bonne valeur ${sudo.complexiteGrille})"
    }
    void test5()
    {
       def g= [[6, 0, 0, 0, 3, 7, 0, 0, 0],[9, 0, 0, 0, 0, 0, 1, 0, 4],[0, 0, 0, 9, 1, 6, 0, 0, 7],[0, 0, 0, 1, 0, 4, 0, 0, 0],[7, 0, 1, 0, 0, 0, 0, 2, 8],[0, 5, 9, 0, 7, 0, 0, 0, 0],[0, 4, 0, 2, 0, 0, 9, 0, 5],[8, 0, 0, 6, 0, 9, 0, 3, 0],[1, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
       Sudoku sudo =  Sudoku.calcul_global(g,false)
       
       assert sudo.modifArbitraire.size() == 0  : "Le système n'a pas de modification arbitraire à faire (${sudo.modifArbitraire})"
       assert sudo.checkGrille()                : "Le système aurait dû être capable de résoudre cette grille !!!"
       assert !sudo.tropDeValeursForcees()      : "Le système n'aurait pas dû forcer autant de valeurs !!!!"
       assert sudo.complexiteGrille == 3        : "Le calcul de la complexité est faux (bonne valeur ${sudo.complexiteGrille})"
    }
    void test6()
    {
       def g= [[0, 0, 0, 0, 0, 0, 6, 0, 0], [0, 1, 0, 0, 0, 2, 8, 0, 3], [0, 9, 0, 0, 5, 8, 0, 0, 0], [0, 3, 0, 0, 0, 0, 7, 0, 4], [6, 2, 0, 7, 8, 0, 0, 0, 0], [5, 0, 0, 0, 6, 3, 0, 0, 0], [4, 0, 0, 0, 9, 5, 0, 0, 0], [0, 7, 0, 8, 0, 0, 5, 0, 0],[0, 0, 0, 0, 2, 0, 9, 8, 0]] as int[][]        
       Sudoku sudo =  Sudoku.calcul_global(g,false)
       
       assert sudo.modifArbitraire.size() == 0  : "Le système n'a pas de modification arbitraire à faire (${sudo.modifArbitraire})"
       assert !sudo.checkGrille()               : "Le système n'aurait pas dû être capable de résoudre cette grille !!!"
       assert sudo.tropDeValeursForcees()       : "Le système n'aurait pas dû forcer autant de valeurs !!!!"
       assert sudo.complexiteGrille == 11       : "Le calcul de la complexité est faux (bonne valeur ${sudo.complexiteGrille})"
    }
}