package lancelikessause.fortressmode;

public class ModConfig {
	public static double creeperJumpHeight = 0.42D;
	public static double creeperJumpStage = 10f;
	public static float knockback = 0.4f;
	public static float monsterMoveSpeed = 1f;
	public static float spiderMoveSpeed = 1.3f;
	public static long spiderWebLife = 20L;
	public static float zombieMoveSpeed = 0.7f;
	public static float zombieSmellRange = 40f; /**distance at which zombies will follow player*/
	public static int zombieSmellRate = 100; /**time between zombie smelling for player**/
	public static int zombieMaxHealth = 40;
	public static int armoredZombieMaxHealth = 80;
	public static float skeletonRetreatDistance =  5f;
	public static float skeletonRetreatSpeed = 0.06f;
	public static int skeletonFireRate = 25;
	public static float skeletonProjectileSpeed = 0.6f;
	public static int spiderFireRate = 30;
	public static float spiderProjectileSpeed = 1.5f;
	public static float spiderFireDistance = 15f;
	public static int wolfAngryChance = 4;
	public static int zombiePigAngryChance = 10;
	public static int slimeMaxHealth = 10;
	public static int slimeJumpDelay = 4;

	public static int trollSpawnRate = 2;
	public static float trollSmellRange = 128f; /**distance at which troll will follow player*/
	public static int trollSmellRate = 1000; /**time between troll smelling for player**/

	public static void initialize() {
	}
}
