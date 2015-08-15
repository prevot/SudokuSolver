public class Sudoku
{
    def etats = new List[9][9]
    def grille= new int[9][9]
    def grille_ini = new int[9][9]
    public boolean modificationEtats = true
    public boolean modeDebug = false
    public static int NB_RESTRICTION_AUTORISER = 3
    public int complexiteGrille  = 0
    public int nbRestriction     = 0
    def modifArbitraire = []
    public static void main(String[] args) 
    {
        
        def g= [[0, 0, 0, 0, 0, 0, 6, 0, 0],
                [0, 1, 0, 0, 0, 2, 8, 0, 3],
                [0, 9, 0, 0, 5, 8, 0, 0, 0],
                [0, 3, 0, 0, 0, 0, 7, 0, 4],
                [6, 2, 0, 7, 8, 0, 0, 0, 0],
                [5, 0, 0, 0, 6, 3, 0, 0, 0],
                [4, 0, 0, 0, 9, 5, 0, 0, 0],
                [0, 7, 0, 8, 0, 0, 5, 0, 0],
                [0, 0, 0, 0, 2, 0, 9, 8, 0]] as int[][] 
        def r= [[0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 
                0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]               
        def s= [[6, 0, 0, 0, 3, 7, 0, 0, 0],[9, 0, 0, 0, 0, 0, 1, 0, 4],[0, 0, 0, 9, 1, 6, 0, 0, 7],[0, 0, 0, 1, 0, 4, 0, 0, 0],[7, 0, 1, 0, 0, 0, 0, 2, 8],[0, 5, 9, 0, 7, 0, 0, 0, 0],[0, 4, 0, 2, 0, 0, 9, 0, 5],[8, 0, 0, 6, 0, 9, 0, 3, 0],[1, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
        def t= [[8, 9, 2, 0, 0, 4, 0, 0, 0],[0, 0, 0, 0, 8, 0, 1, 0, 4],[5, 0, 0, 0, 3, 0, 0, 0, 0],[0, 0, 0, 0, 2, 8, 3, 0, 1],[0, 1, 4, 0, 0, 6, 0, 0, 0],[6, 0, 0, 0, 0, 0, 7, 0, 0],[0, 2, 7, 0, 0, 0, 0, 0, 8],[0, 0, 0, 0, 0, 0, 2, 0, 0],[3, 0, 0, 0, 4, 0, 0, 5, 0]] as int[][]
        def z= [[0, 9, 0, 0, 0, 4, 0, 0, 0],[0, 0, 0, 0, 8, 0, 1, 0, 4],[5, 0, 0, 0, 3, 0, 0, 0, 0],[0, 0, 0, 0, 2, 8, 3, 0, 1],[0, 1, 4, 0, 0, 6, 0, 0, 0],[6, 0, 0, 0, 0, 0, 7, 0, 0],[0, 2, 7, 0, 0, 0, 0, 0, 8],[0, 0, 0, 0, 0, 0, 2, 0, 0],[3, 0, 0, 0, 4, 0, 0, 5, 0]] as int[][]
        def u= [[2, 0, 0, 0, 0, 5, 8, 6, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 7, 4, 2, 8, 0, 0, 9],[0, 0, 9, 0, 0, 0, 1, 7, 2],[0, 0, 0, 0, 0, 0, 6, 0, 0],[6, 2, 0, 3, 9, 0, 4, 0, 0],[0, 0, 0, 0, 1, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 8, 0],[1, 0, 4, 7, 0, 0, 5, 0, 0]] as int[][]
        def x= [[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
        
        Sudoku sudo = calcul_global(g,true)
        sudo.printGrille("Grille initiale")
        if (sudo.modifArbitraire.size() > 0) println "modification(s) arbitraire(s) apportée(s) :" + sudo.modifArbitraire
        if (sudo.checkGrille()) sudo.printGrille("Grille résolue")
        if (sudo.tropDeValeursForcees()) 
                  println "Le solveur n'arrive pas à résoudre cette grille !!!!! Vous pouvez forcer manuellement une valeur ou relancer le programme pour une résolution aléatoire !!!!"

        println "Complexite de la grille : ${sudo.complexiteGrille}"

    }
    
    static Sudoku calcul_global(final int[][] g, boolean modeDebug)
    {
        def sudoku = new Sudoku(grille:g,grille_ini : copyTableau(g))
        sudoku.modeDebug = modeDebug
        while(sudoku.modificationEtats)
        {
            sudoku.complexiteGrille ++
            sudoku.rechercherEtats()
            sudoku.reduireEtats()
            sudoku.reduireEtatsN2()
            sudoku.reduireEtats()
            //sudoku.printEtats()
            sudoku.ecrireResultats()
            if (sudoku.modificationEtats)
            {
                if (sudoku.modeDebug) sudoku.printGrille()
            }
            else
            {
                if (!sudoku.checkGrille()) 
                { 
                    sudoku.complexiteGrille ++
                    if (!sudoku.tropDeValeursForcees()) 
                    {
                        sudoku.fixerValeur()
                        sudoku.modificationEtats = !sudoku.tropDeValeursForcees() 
                        sudoku.nbRestriction++
                    }
                }
             }
         }
         return sudoku
    }
    
    static int[][] copyTableau(final int[][] tab)
    {
        int[][] tableau = new int[9][9]
        (0..<9).each{i-> (0..<9).each{j-> tableau[i][j] = tab[i][j]  }}
        return tableau
    }
    boolean tropDeValeursForcees()
    {
        return nbRestriction >= NB_RESTRICTION_AUTORISER
    }
    boolean estNombreCandidat(int i,int j,int valeurProposee) 
    {
        boolean estUneBonneValeur = true
        (0..<9).each{r->      if (r != j && grille[i][r] == valeurProposee)  estUneBonneValeur = false  }
        (0..<9).each{r->      if (r != i && grille[r][j] == valeurProposee)  estUneBonneValeur = false  }
        int i0 = i - i % 3
        int j0 = j - j % 3
        (i0..<i0+3).each{r->
          (j0..<j0+3).each{c-> if (r != i && c != j && grille[r][c] == valeurProposee)  estUneBonneValeur = false } }
        return estUneBonneValeur
    }
    boolean checkGrille()
    {
        boolean res = true
        (1..<10).each{nombre->
                        (0..<9).each{i-> 
                                    boolean good1 = false;boolean good2 = false
                                    (0..<9).each{j->
                                                    if ( grille[i][j] == nombre) good1 = true 
                                                    if ( grille[j][i] == nombre) good2 = true 
                                                }
                                    //println (good1 && good2).toString() 
                                    if (res) res = good1 && good2
                                   }
                     }
        return res
    }

    void cleanEtats(def pos, int valeur, int valeur2 =0)
    {
          def oldVal =""
          if (pos.size() == 2) 
          {
              if (!etats[pos[0]][pos[1]].contains(valeur) || (valeur2>0 && !etats[pos[0]][pos[1]].contains(valeur2))) println "ERREUR !!!" 
             // print "modification etats[${pos[0]}][${pos[1]}] = ${etats[pos[0]][pos[1]]}"
              oldVal = etats[pos[0]][pos[1]]
              etats[pos[0]][pos[1]] =[]
              etats[pos[0]][pos[1]] << valeur
              if (valeur2>0) etats[pos[0]][pos[1]] << valeur2
             // if (pos[0]==6 && pos[1]==7) println "etcl ${pos[0]} ${pos[1]} :::  ${etats[pos[0]][pos[1]]}"
              if (modeDebug && oldVal != etats[pos[0]][pos[1]]) println "modification etats[${pos[0]}][${pos[1]}] = ${oldVal}------> ${etats[pos[0]][pos[1]]}"
          }
    }

    
    void reduireEtats()
    {
        def pos1;def pos2 ; def pos3;
        (1..<10).each
        {valeur->     
            (0..<9).each
            {i-> 
                pos1=[];pos2=[];pos3=[];
                (0..<9).each
                {j->
                    if (etats[i][j].contains(valeur)) pos1 << i << j
                    if (etats[j][i].contains(valeur)) pos2 << j << i
                }
                def i0 = (i * 3) % 9
                def j0 = i - (i) % 3
                (i0..<i0+3).each
                {m->
                    (j0..<j0+3).each
                    {n-> 
                        if (etats[m][n].contains(valeur)) pos3 << m << n 
                    } 
                }
                //println valeur + " : " + pos3
                cleanEtats(pos1,valeur)
                cleanEtats(pos2,valeur) 
                cleanEtats(pos3,valeur)
            }
        }
    }
    void reduireEtatsN2()
    {
        def pos;def posG
        def updateEtats=
        { a,iINF,iSUP,posG2->
          def posF =[]
          posF << posG2[iSUP][a] << posG2[iSUP][a+1]
          cleanEtats(posF,iINF+1, iSUP+1)
        }
        def indexDoublon=
        { posG2,doublon2,position->
            int cpt = 0
            int res = 99999
            posG2.eachWithIndex
            {item, index-> 
                if (item == doublon2) 
                { 
                    cpt++
                    
                    if (cpt == position) res = index
                }
            }
            return res
        }
        (0..<9).each
            {i-> 
                posG=[] 
                def i0 = (i * 3) % 9
                def j0 = i - (i) % 3
                (1..<10).each
                {valeur->
                    pos=[] 
                    (i0..<i0+3).each
                    {m->
                        (j0..<j0+3).each
                        {n-> 
                            if (etats[m][n].contains(valeur)) pos << m << n
                        } 
                    }
                    posG << pos
                 }
                 def doublons = []
                 posG.eachWithIndex{item, index-> if (item && posG.count(item) ==2 && item.size() == 4)   { doublons << item } }
                 doublons?.unique().each
                 { doublon ->
                     def indexInf = indexDoublon(posG,doublon,1)
                     def indexSup = indexDoublon(posG,doublon,2)
                     updateEtats(0,indexInf,indexSup,posG)
                     updateEtats(2,indexInf,indexSup,posG)
                 }
                // println "doublons sous grille ${i+1}/9 doublons:" + doublons+ "--- posG:" + posG
               //  posG.eachWithIndex{item, index-> if (item && posG.count(item) ==3)   {  println "3 idem :" + item  +".." +(index+1).toString() } }
            }   
    }
    
    void rechercherEtats()
    {
        (0..<9).each{i->
            (0..<9).each{j->
                    etats[i][j]= [] 
                    if ( grille[i][j] == 0) (1..<10).each
                    {r->  
                        if (estNombreCandidat(i,j,r))
                        {
                         etats[i][j] << r  
                         
                         }
                       //  if (i==6 && j==7) println "etas ${i} ${j} :::  ${etats[i][j]}"
                    }
             }
        }
    }
    
    void fixerValeur(int nbPossibilites = 2)
    {
        boolean uneModif = false  
        boolean possibilitesExiste = false
        int choix = nbPossibilites-2
        //int choix = (new java.util.Random()).nextInt(2)  
        (0..<9).each{i->
            (0..<9).each{j->
                    if (etats[i][j].size() == 2 &&  grille[i][j] == 0 && !uneModif)
                    {
                         grille[i][j] = etats[i][j][choix]
                         modificationEtats = true
                         uneModif = true
                         modifArbitraire << "etat[${i}][${j}] = ${etats[i][j]} -----> ${etats[i][j][choix]}"
                    }
                    if (etats[i][j].size() > 0) possibilitesExiste = true 
             }
        }
        if (possibilitesExiste && !uneModif && nbPossibilites <6)
        {
            println "essai avec ${nbPossibilites} ${printEtats()}"
            complexiteGrille ++
            fixerValeur(nbPossibilites+1)
        }
    }

    void ecrireResultats()
    { 
        modificationEtats = false
        def modifs=[]
        (0..<9).each{i->
            (0..<9).each{j->
                    if ( etats[i][j].size() == 1 && grille[i][j] == 0)  
                    {
                        grille[i][j] = etats[i][j][0]
                        modificationEtats = true
                        modifs << etats[i][j][0]
                    }
             }
        }
        if (modeDebug && modificationEtats) println "modifications apportées : " + modifs
    }
    
    void printGrille(arg1)   
    {
        def printGrille = grille
        if (arg1 == 'Grille initiale') printGrille = grille_ini 
        println "------ ${arg1?arg1:''} --------"; (0..<9).each{i-> println printGrille[i] }   
    }
    void printEtats()    { println etats    }
}