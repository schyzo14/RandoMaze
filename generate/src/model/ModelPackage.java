/**
 */
package model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link model.impl.IndividuImpl <em>Individu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.IndividuImpl
	 * @see model.impl.ModelPackageImpl#getIndividu()
	 * @generated
	 */
	int INDIVIDU = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDU__ID = 0;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDU__NOM = 1;

	/**
	 * The feature id for the '<em><b>Point Vie</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDU__POINT_VIE = 2;

	/**
	 * The number of structural features of the '<em>Individu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDU_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Je Parle</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDU___JE_PARLE = 0;

	/**
	 * The number of operations of the '<em>Individu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDU_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link model.impl.PersonnageImpl <em>Personnage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.PersonnageImpl
	 * @see model.impl.ModelPackageImpl#getPersonnage()
	 * @generated
	 */
	int PERSONNAGE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE__ID = INDIVIDU__ID;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE__NOM = INDIVIDU__NOM;

	/**
	 * The feature id for the '<em><b>Point Vie</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE__POINT_VIE = INDIVIDU__POINT_VIE;

	/**
	 * The number of structural features of the '<em>Personnage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE_FEATURE_COUNT = INDIVIDU_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Je Parle</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE___JE_PARLE = INDIVIDU___JE_PARLE;

	/**
	 * The operation id for the '<em>Creer Personnage</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE___CREER_PERSONNAGE__STRING = INDIVIDU_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE___TO_STRING = INDIVIDU_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Save Perso</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE___SAVE_PERSO__PERSONNAGE_PIECE_INT = INDIVIDU_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Creer Personnage</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE___CREER_PERSONNAGE__STRING_INT = INDIVIDU_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Move</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE___MOVE__PIECE_PORTE = INDIVIDU_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Personnage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNAGE_OPERATION_COUNT = INDIVIDU_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link model.impl.PieceImpl <em>Piece</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.PieceImpl
	 * @see model.impl.ModelPackageImpl#getPiece()
	 * @generated
	 */
	int PIECE = 2;

	/**
	 * The feature id for the '<em><b>Id Piece</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIECE__ID_PIECE = 0;

	/**
	 * The feature id for the '<em><b>Nom Serveur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIECE__NOM_SERVEUR = 1;

	/**
	 * The feature id for the '<em><b>Position X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIECE__POSITION_X = 2;

	/**
	 * The feature id for the '<em><b>Position Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIECE__POSITION_Y = 3;

	/**
	 * The number of structural features of the '<em>Piece</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIECE_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Fuir</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIECE___FUIR__PORTE_PIECE_PERSONNAGE = 0;

	/**
	 * The number of operations of the '<em>Piece</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIECE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link model.impl.PorteImpl <em>Porte</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.PorteImpl
	 * @see model.impl.ModelPackageImpl#getPorte()
	 * @generated
	 */
	int PORTE = 3;

	/**
	 * The feature id for the '<em><b>Id Porte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTE__ID_PORTE = 0;

	/**
	 * The feature id for the '<em><b>Situation Porte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTE__SITUATION_PORTE = 1;

	/**
	 * The number of structural features of the '<em>Porte</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Porte</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.MonstreImpl <em>Monstre</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.MonstreImpl
	 * @see model.impl.ModelPackageImpl#getMonstre()
	 * @generated
	 */
	int MONSTRE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTRE__ID = INDIVIDU__ID;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTRE__NOM = INDIVIDU__NOM;

	/**
	 * The feature id for the '<em><b>Point Vie</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTRE__POINT_VIE = INDIVIDU__POINT_VIE;

	/**
	 * The number of structural features of the '<em>Monstre</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTRE_FEATURE_COUNT = INDIVIDU_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Je Parle</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTRE___JE_PARLE = INDIVIDU___JE_PARLE;

	/**
	 * The operation id for the '<em>Create Monster</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTRE___CREATE_MONSTER = INDIVIDU_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Monstre</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTRE_OPERATION_COUNT = INDIVIDU_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.PartieImpl <em>Partie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.PartieImpl
	 * @see model.impl.ModelPackageImpl#getPartie()
	 * @generated
	 */
	int PARTIE = 5;

	/**
	 * The number of structural features of the '<em>Partie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Jouer Tour</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIE___JOUER_TOUR = 0;

	/**
	 * The operation id for the '<em>Quitter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIE___QUITTER = 1;

	/**
	 * The operation id for the '<em>Ret Demande Confirmation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIE___RET_DEMANDE_CONFIRMATION = 2;

	/**
	 * The operation id for the '<em>Confirmation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIE___CONFIRMATION__BOOLEAN = 3;

	/**
	 * The operation id for the '<em>Sauvegarde</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIE___SAUVEGARDE__INDIVIDU = 4;

	/**
	 * The operation id for the '<em>Afficher Joueur</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIE___AFFICHER_JOUEUR__INT_PERSONNAGE = 5;

	/**
	 * The number of operations of the '<em>Partie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIE_OPERATION_COUNT = 6;

	/**
	 * The meta object id for the '{@link model.impl.UnicastRemoteObjectImpl <em>Unicast Remote Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.UnicastRemoteObjectImpl
	 * @see model.impl.ModelPackageImpl#getUnicastRemoteObject()
	 * @generated
	 */
	int UNICAST_REMOTE_OBJECT = 7;

	/**
	 * The number of structural features of the '<em>Unicast Remote Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST_REMOTE_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Unicast Remote Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST_REMOTE_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.LabyrintheImpl <em>Labyrinthe Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.LabyrintheImpl
	 * @see model.impl.ModelPackageImpl#getLabyrintheImpl()
	 * @generated
	 */
	int LABYRINTHE_IMPL = 6;

	/**
	 * The number of structural features of the '<em>Labyrinthe Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABYRINTHE_IMPL_FEATURE_COUNT = UNICAST_REMOTE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Labyrinthe Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABYRINTHE_IMPL_OPERATION_COUNT = UNICAST_REMOTE_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.Remote <em>Remote</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Remote
	 * @see model.impl.ModelPackageImpl#getRemote()
	 * @generated
	 */
	int REMOTE = 9;

	/**
	 * The number of structural features of the '<em>Remote</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Remote</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.Labyrinthe <em>Labyrinthe</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Labyrinthe
	 * @see model.impl.ModelPackageImpl#getLabyrinthe()
	 * @generated
	 */
	int LABYRINTHE = 8;

	/**
	 * The number of structural features of the '<em>Labyrinthe</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABYRINTHE_FEATURE_COUNT = REMOTE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Labyrinthe</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABYRINTHE_OPERATION_COUNT = REMOTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.UtilisateurImpl <em>Utilisateur</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.UtilisateurImpl
	 * @see model.impl.ModelPackageImpl#getUtilisateur()
	 * @generated
	 */
	int UTILISATEUR = 10;

	/**
	 * The feature id for the '<em><b>Id Utilisateur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATEUR__ID_UTILISATEUR = 0;

	/**
	 * The feature id for the '<em><b>Nom Utilisateur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATEUR__NOM_UTILISATEUR = 1;

	/**
	 * The feature id for the '<em><b>Mdp Utilisateur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATEUR__MDP_UTILISATEUR = 2;

	/**
	 * The number of structural features of the '<em>Utilisateur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATEUR_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Se Connecter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATEUR___SE_CONNECTER__STRING_STRING = 0;

	/**
	 * The number of operations of the '<em>Utilisateur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATEUR_OPERATION_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link model.Individu <em>Individu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Individu</em>'.
	 * @see model.Individu
	 * @generated
	 */
	EClass getIndividu();

	/**
	 * Returns the meta object for the attribute '{@link model.Individu#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see model.Individu#getId()
	 * @see #getIndividu()
	 * @generated
	 */
	EAttribute getIndividu_Id();

	/**
	 * Returns the meta object for the attribute '{@link model.Individu#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see model.Individu#getNom()
	 * @see #getIndividu()
	 * @generated
	 */
	EAttribute getIndividu_Nom();

	/**
	 * Returns the meta object for the attribute '{@link model.Individu#getPointVie <em>Point Vie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point Vie</em>'.
	 * @see model.Individu#getPointVie()
	 * @see #getIndividu()
	 * @generated
	 */
	EAttribute getIndividu_PointVie();

	/**
	 * Returns the meta object for the '{@link model.Individu#jeParle() <em>Je Parle</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Je Parle</em>' operation.
	 * @see model.Individu#jeParle()
	 * @generated
	 */
	EOperation getIndividu__JeParle();

	/**
	 * Returns the meta object for class '{@link model.Personnage <em>Personnage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Personnage</em>'.
	 * @see model.Personnage
	 * @generated
	 */
	EClass getPersonnage();

	/**
	 * Returns the meta object for the '{@link model.Personnage#creerPersonnage(java.lang.String) <em>Creer Personnage</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Creer Personnage</em>' operation.
	 * @see model.Personnage#creerPersonnage(java.lang.String)
	 * @generated
	 */
	EOperation getPersonnage__CreerPersonnage__String();

	/**
	 * Returns the meta object for the '{@link model.Personnage#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see model.Personnage#toString()
	 * @generated
	 */
	EOperation getPersonnage__ToString();

	/**
	 * Returns the meta object for the '{@link model.Personnage#save_Perso(model.Personnage, model.Piece, int) <em>Save Perso</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Save Perso</em>' operation.
	 * @see model.Personnage#save_Perso(model.Personnage, model.Piece, int)
	 * @generated
	 */
	EOperation getPersonnage__Save_Perso__Personnage_Piece_int();

	/**
	 * Returns the meta object for the '{@link model.Personnage#creerPersonnage(java.lang.String, int) <em>Creer Personnage</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Creer Personnage</em>' operation.
	 * @see model.Personnage#creerPersonnage(java.lang.String, int)
	 * @generated
	 */
	EOperation getPersonnage__CreerPersonnage__String_int();

	/**
	 * Returns the meta object for the '{@link model.Personnage#move(model.Piece, model.Porte) <em>Move</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Move</em>' operation.
	 * @see model.Personnage#move(model.Piece, model.Porte)
	 * @generated
	 */
	EOperation getPersonnage__Move__Piece_Porte();

	/**
	 * Returns the meta object for class '{@link model.Piece <em>Piece</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Piece</em>'.
	 * @see model.Piece
	 * @generated
	 */
	EClass getPiece();

	/**
	 * Returns the meta object for the attribute '{@link model.Piece#getIdPiece <em>Id Piece</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Piece</em>'.
	 * @see model.Piece#getIdPiece()
	 * @see #getPiece()
	 * @generated
	 */
	EAttribute getPiece_IdPiece();

	/**
	 * Returns the meta object for the attribute '{@link model.Piece#getNomServeur <em>Nom Serveur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom Serveur</em>'.
	 * @see model.Piece#getNomServeur()
	 * @see #getPiece()
	 * @generated
	 */
	EAttribute getPiece_NomServeur();

	/**
	 * Returns the meta object for the attribute '{@link model.Piece#getPositionX <em>Position X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position X</em>'.
	 * @see model.Piece#getPositionX()
	 * @see #getPiece()
	 * @generated
	 */
	EAttribute getPiece_PositionX();

	/**
	 * Returns the meta object for the attribute '{@link model.Piece#getPositionY <em>Position Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position Y</em>'.
	 * @see model.Piece#getPositionY()
	 * @see #getPiece()
	 * @generated
	 */
	EAttribute getPiece_PositionY();

	/**
	 * Returns the meta object for the '{@link model.Piece#fuir(model.Porte, model.Piece, model.Personnage) <em>Fuir</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Fuir</em>' operation.
	 * @see model.Piece#fuir(model.Porte, model.Piece, model.Personnage)
	 * @generated
	 */
	EOperation getPiece__Fuir__Porte_Piece_Personnage();

	/**
	 * Returns the meta object for class '{@link model.Porte <em>Porte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Porte</em>'.
	 * @see model.Porte
	 * @generated
	 */
	EClass getPorte();

	/**
	 * Returns the meta object for the attribute '{@link model.Porte#getIdPorte <em>Id Porte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Porte</em>'.
	 * @see model.Porte#getIdPorte()
	 * @see #getPorte()
	 * @generated
	 */
	EAttribute getPorte_IdPorte();

	/**
	 * Returns the meta object for the attribute '{@link model.Porte#getSituationPorte <em>Situation Porte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Situation Porte</em>'.
	 * @see model.Porte#getSituationPorte()
	 * @see #getPorte()
	 * @generated
	 */
	EAttribute getPorte_SituationPorte();

	/**
	 * Returns the meta object for class '{@link model.Monstre <em>Monstre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monstre</em>'.
	 * @see model.Monstre
	 * @generated
	 */
	EClass getMonstre();

	/**
	 * Returns the meta object for the '{@link model.Monstre#createMonster() <em>Create Monster</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Monster</em>' operation.
	 * @see model.Monstre#createMonster()
	 * @generated
	 */
	EOperation getMonstre__CreateMonster();

	/**
	 * Returns the meta object for class '{@link model.Partie <em>Partie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partie</em>'.
	 * @see model.Partie
	 * @generated
	 */
	EClass getPartie();

	/**
	 * Returns the meta object for the '{@link model.Partie#jouerTour() <em>Jouer Tour</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Jouer Tour</em>' operation.
	 * @see model.Partie#jouerTour()
	 * @generated
	 */
	EOperation getPartie__JouerTour();

	/**
	 * Returns the meta object for the '{@link model.Partie#quitter() <em>Quitter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Quitter</em>' operation.
	 * @see model.Partie#quitter()
	 * @generated
	 */
	EOperation getPartie__Quitter();

	/**
	 * Returns the meta object for the '{@link model.Partie#retDemandeConfirmation() <em>Ret Demande Confirmation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Ret Demande Confirmation</em>' operation.
	 * @see model.Partie#retDemandeConfirmation()
	 * @generated
	 */
	EOperation getPartie__RetDemandeConfirmation();

	/**
	 * Returns the meta object for the '{@link model.Partie#confirmation(boolean) <em>Confirmation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Confirmation</em>' operation.
	 * @see model.Partie#confirmation(boolean)
	 * @generated
	 */
	EOperation getPartie__Confirmation__boolean();

	/**
	 * Returns the meta object for the '{@link model.Partie#sauvegarde(model.Individu) <em>Sauvegarde</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sauvegarde</em>' operation.
	 * @see model.Partie#sauvegarde(model.Individu)
	 * @generated
	 */
	EOperation getPartie__Sauvegarde__Individu();

	/**
	 * Returns the meta object for the '{@link model.Partie#afficherJoueur(int, model.Personnage) <em>Afficher Joueur</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Afficher Joueur</em>' operation.
	 * @see model.Partie#afficherJoueur(int, model.Personnage)
	 * @generated
	 */
	EOperation getPartie__AfficherJoueur__int_Personnage();

	/**
	 * Returns the meta object for class '{@link model.Labyrinthe <em>Labyrinthe Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labyrinthe Impl</em>'.
	 * @see model.Labyrinthe
	 * @generated
	 */
	EClass getLabyrintheImpl();

	/**
	 * Returns the meta object for class '{@link model.UnicastRemoteObject <em>Unicast Remote Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unicast Remote Object</em>'.
	 * @see model.UnicastRemoteObject
	 * @generated
	 */
	EClass getUnicastRemoteObject();

	/**
	 * Returns the meta object for class '{@link model.Labyrinthe <em>Labyrinthe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labyrinthe</em>'.
	 * @see model.Labyrinthe
	 * @generated
	 */
	EClass getLabyrinthe();

	/**
	 * Returns the meta object for class '{@link model.Remote <em>Remote</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote</em>'.
	 * @see model.Remote
	 * @generated
	 */
	EClass getRemote();

	/**
	 * Returns the meta object for class '{@link model.Utilisateur <em>Utilisateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Utilisateur</em>'.
	 * @see model.Utilisateur
	 * @generated
	 */
	EClass getUtilisateur();

	/**
	 * Returns the meta object for the attribute '{@link model.Utilisateur#getIdUtilisateur <em>Id Utilisateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Utilisateur</em>'.
	 * @see model.Utilisateur#getIdUtilisateur()
	 * @see #getUtilisateur()
	 * @generated
	 */
	EAttribute getUtilisateur_IdUtilisateur();

	/**
	 * Returns the meta object for the attribute '{@link model.Utilisateur#getNomUtilisateur <em>Nom Utilisateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom Utilisateur</em>'.
	 * @see model.Utilisateur#getNomUtilisateur()
	 * @see #getUtilisateur()
	 * @generated
	 */
	EAttribute getUtilisateur_NomUtilisateur();

	/**
	 * Returns the meta object for the attribute '{@link model.Utilisateur#getMdpUtilisateur <em>Mdp Utilisateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mdp Utilisateur</em>'.
	 * @see model.Utilisateur#getMdpUtilisateur()
	 * @see #getUtilisateur()
	 * @generated
	 */
	EAttribute getUtilisateur_MdpUtilisateur();

	/**
	 * Returns the meta object for the '{@link model.Utilisateur#seConnecter(java.lang.String, java.lang.String) <em>Se Connecter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Se Connecter</em>' operation.
	 * @see model.Utilisateur#seConnecter(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getUtilisateur__SeConnecter__String_String();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link model.impl.IndividuImpl <em>Individu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.IndividuImpl
		 * @see model.impl.ModelPackageImpl#getIndividu()
		 * @generated
		 */
		EClass INDIVIDU = eINSTANCE.getIndividu();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDIVIDU__ID = eINSTANCE.getIndividu_Id();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDIVIDU__NOM = eINSTANCE.getIndividu_Nom();

		/**
		 * The meta object literal for the '<em><b>Point Vie</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDIVIDU__POINT_VIE = eINSTANCE.getIndividu_PointVie();

		/**
		 * The meta object literal for the '<em><b>Je Parle</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INDIVIDU___JE_PARLE = eINSTANCE.getIndividu__JeParle();

		/**
		 * The meta object literal for the '{@link model.impl.PersonnageImpl <em>Personnage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.PersonnageImpl
		 * @see model.impl.ModelPackageImpl#getPersonnage()
		 * @generated
		 */
		EClass PERSONNAGE = eINSTANCE.getPersonnage();

		/**
		 * The meta object literal for the '<em><b>Creer Personnage</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERSONNAGE___CREER_PERSONNAGE__STRING = eINSTANCE.getPersonnage__CreerPersonnage__String();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERSONNAGE___TO_STRING = eINSTANCE.getPersonnage__ToString();

		/**
		 * The meta object literal for the '<em><b>Save Perso</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERSONNAGE___SAVE_PERSO__PERSONNAGE_PIECE_INT = eINSTANCE.getPersonnage__Save_Perso__Personnage_Piece_int();

		/**
		 * The meta object literal for the '<em><b>Creer Personnage</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERSONNAGE___CREER_PERSONNAGE__STRING_INT = eINSTANCE.getPersonnage__CreerPersonnage__String_int();

		/**
		 * The meta object literal for the '<em><b>Move</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERSONNAGE___MOVE__PIECE_PORTE = eINSTANCE.getPersonnage__Move__Piece_Porte();

		/**
		 * The meta object literal for the '{@link model.impl.PieceImpl <em>Piece</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.PieceImpl
		 * @see model.impl.ModelPackageImpl#getPiece()
		 * @generated
		 */
		EClass PIECE = eINSTANCE.getPiece();

		/**
		 * The meta object literal for the '<em><b>Id Piece</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIECE__ID_PIECE = eINSTANCE.getPiece_IdPiece();

		/**
		 * The meta object literal for the '<em><b>Nom Serveur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIECE__NOM_SERVEUR = eINSTANCE.getPiece_NomServeur();

		/**
		 * The meta object literal for the '<em><b>Position X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIECE__POSITION_X = eINSTANCE.getPiece_PositionX();

		/**
		 * The meta object literal for the '<em><b>Position Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIECE__POSITION_Y = eINSTANCE.getPiece_PositionY();

		/**
		 * The meta object literal for the '<em><b>Fuir</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PIECE___FUIR__PORTE_PIECE_PERSONNAGE = eINSTANCE.getPiece__Fuir__Porte_Piece_Personnage();

		/**
		 * The meta object literal for the '{@link model.impl.PorteImpl <em>Porte</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.PorteImpl
		 * @see model.impl.ModelPackageImpl#getPorte()
		 * @generated
		 */
		EClass PORTE = eINSTANCE.getPorte();

		/**
		 * The meta object literal for the '<em><b>Id Porte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTE__ID_PORTE = eINSTANCE.getPorte_IdPorte();

		/**
		 * The meta object literal for the '<em><b>Situation Porte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORTE__SITUATION_PORTE = eINSTANCE.getPorte_SituationPorte();

		/**
		 * The meta object literal for the '{@link model.impl.MonstreImpl <em>Monstre</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.MonstreImpl
		 * @see model.impl.ModelPackageImpl#getMonstre()
		 * @generated
		 */
		EClass MONSTRE = eINSTANCE.getMonstre();

		/**
		 * The meta object literal for the '<em><b>Create Monster</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MONSTRE___CREATE_MONSTER = eINSTANCE.getMonstre__CreateMonster();

		/**
		 * The meta object literal for the '{@link model.impl.PartieImpl <em>Partie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.PartieImpl
		 * @see model.impl.ModelPackageImpl#getPartie()
		 * @generated
		 */
		EClass PARTIE = eINSTANCE.getPartie();

		/**
		 * The meta object literal for the '<em><b>Jouer Tour</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTIE___JOUER_TOUR = eINSTANCE.getPartie__JouerTour();

		/**
		 * The meta object literal for the '<em><b>Quitter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTIE___QUITTER = eINSTANCE.getPartie__Quitter();

		/**
		 * The meta object literal for the '<em><b>Ret Demande Confirmation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTIE___RET_DEMANDE_CONFIRMATION = eINSTANCE.getPartie__RetDemandeConfirmation();

		/**
		 * The meta object literal for the '<em><b>Confirmation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTIE___CONFIRMATION__BOOLEAN = eINSTANCE.getPartie__Confirmation__boolean();

		/**
		 * The meta object literal for the '<em><b>Sauvegarde</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTIE___SAUVEGARDE__INDIVIDU = eINSTANCE.getPartie__Sauvegarde__Individu();

		/**
		 * The meta object literal for the '<em><b>Afficher Joueur</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTIE___AFFICHER_JOUEUR__INT_PERSONNAGE = eINSTANCE.getPartie__AfficherJoueur__int_Personnage();

		/**
		 * The meta object literal for the '{@link model.impl.LabyrintheImpl <em>Labyrinthe Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.LabyrintheImpl
		 * @see model.impl.ModelPackageImpl#getLabyrintheImpl()
		 * @generated
		 */
		EClass LABYRINTHE_IMPL = eINSTANCE.getLabyrintheImpl();

		/**
		 * The meta object literal for the '{@link model.impl.UnicastRemoteObjectImpl <em>Unicast Remote Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.UnicastRemoteObjectImpl
		 * @see model.impl.ModelPackageImpl#getUnicastRemoteObject()
		 * @generated
		 */
		EClass UNICAST_REMOTE_OBJECT = eINSTANCE.getUnicastRemoteObject();

		/**
		 * The meta object literal for the '{@link model.Labyrinthe <em>Labyrinthe</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.Labyrinthe
		 * @see model.impl.ModelPackageImpl#getLabyrinthe()
		 * @generated
		 */
		EClass LABYRINTHE = eINSTANCE.getLabyrinthe();

		/**
		 * The meta object literal for the '{@link model.Remote <em>Remote</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.Remote
		 * @see model.impl.ModelPackageImpl#getRemote()
		 * @generated
		 */
		EClass REMOTE = eINSTANCE.getRemote();

		/**
		 * The meta object literal for the '{@link model.impl.UtilisateurImpl <em>Utilisateur</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.UtilisateurImpl
		 * @see model.impl.ModelPackageImpl#getUtilisateur()
		 * @generated
		 */
		EClass UTILISATEUR = eINSTANCE.getUtilisateur();

		/**
		 * The meta object literal for the '<em><b>Id Utilisateur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UTILISATEUR__ID_UTILISATEUR = eINSTANCE.getUtilisateur_IdUtilisateur();

		/**
		 * The meta object literal for the '<em><b>Nom Utilisateur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UTILISATEUR__NOM_UTILISATEUR = eINSTANCE.getUtilisateur_NomUtilisateur();

		/**
		 * The meta object literal for the '<em><b>Mdp Utilisateur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UTILISATEUR__MDP_UTILISATEUR = eINSTANCE.getUtilisateur_MdpUtilisateur();

		/**
		 * The meta object literal for the '<em><b>Se Connecter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UTILISATEUR___SE_CONNECTER__STRING_STRING = eINSTANCE.getUtilisateur__SeConnecter__String_String();

	}

} //ModelPackage
