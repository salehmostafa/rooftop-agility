package data;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

public enum Obstacle {
	GNOME1("Log balance", new Position(2474, 3435, 0), new Area(2469, 3436, 2490, 3440), City.GNOME_AGILITY),
	GNOME2("Obstacle net", new Position(2473, 3425, 0), new Area(2480, 3425, 2469, 3429), City.GNOME_AGILITY),
	GNOME3("Tree branch", new Position(2473, 3422, 1), new Area(2476, 3422, 2471, 3424), City.GNOME_AGILITY),
	GNOME4("Balancing rope", new Position(2478, 3420, 2), new Area(2472, 3418, 2477, 3421), City.GNOME_AGILITY),
	GNOME5("Tree branch", new Position(2486, 3419, 2), new Area(2488, 3418, 2483, 3421), City.GNOME_AGILITY),
	GNOME6("Obstacle net", new Position(2485, 3426, 0), new Area(2481, 3426, 2489, 3420), City.GNOME_AGILITY),
	GNOME7("Obstacle pipe", new Position(2484, 3431, 0), new Area(2479, 3431, 2490, 3427), City.GNOME_AGILITY),
	
	DRAYNOR1("Tightrope", new Position(3098, 3277, 3), new Area(3096, 3281, 3103, 3276), City.DRAYNOR),
	DRAYNOR2("Tightrope", new Position(3092, 3276, 3), new Area(3093, 3279, 3086, 3272), City.DRAYNOR),
	DRAYNOR3("Narrow wall", new Position(3089, 3264, 3), new Area(3088, 3264, 3095, 3269), City.DRAYNOR),
	DRAYNOR4("Wall", new Position(3088, 3256, 3), new Area(3083, 3256, 3089, 3262), City.DRAYNOR),
	DRAYNOR5("Gap", new Position(3095, 3255 ,3), new Area(3087, 3255, 3094, 3251), City.DRAYNOR),
	DRAYNOR6("Crate", new Position(3102, 3261, 3), new Area(3095, 3262, 3101, 3254), City.DRAYNOR),
	
	ALKHARID1("Tightrope", new Position(3272, 3181, 3), new Area(3269, 3181, 3279, 3192), City.ALKHARID),
	ALKHARID2("Cable", new Position(3269, 3166, 3), new Area(3265, 3161, 3272, 3173), City.ALKHARID),
	ALKHARID3("Zip line", new Position(3302, 3163, 3), new Area(3302, 3160, 3283, 3176), City.ALKHARID),
	ALKHARID4("Tropical tree", new Position(3318, 3166, 1), new Area(3313, 3165, 3318, 3160), City.ALKHARID),
	ALKHARID5("Roof top beams", new Position(3316, 3179, 2), new Area(3312, 3378, 3318, 3172), City.ALKHARID),
	ALKHARID6("Tightrope", new Position(3313, 3186, 3), new Area(3312, 3186, 3318, 3180), City.ALKHARID),
	ALKHARID7("Gap", new Position(3300, 3193, 3), new Area(3297, 3194, 3307, 3185), City.ALKHARID),
	
	VARROCK1("Clothes line", new Position(3213, 3414, 3), new Area(3219, 3419, 3214, 3410), City.VARROCK),
	VARROCK2("Gap", new Position(3200, 3416, 3), new Area(3209, 3409, 3200, 3420), City.VARROCK),
	VARROCK3("Wall", new Position(3191, 3415, 1), new Area(3192, 3417, 3198, 3415), City.VARROCK),
	VARROCK4("Gap", new Position(3193, 3401, 3), new Area(3198, 3402, 3192, 3406), City.VARROCK),
	VARROCK5("Gap", new Position(3209, 3397, 3), new Area(3181, 3381, 3210, 3404), City.VARROCK),
	VARROCK6("Gap", new Position(3233, 3402, 3), new Area(3233, 3403, 3217, 3394), City.VARROCK),
	VARROCK7("Ledge", new Position(3236, 3409, 3), new Area(3240, 3403, 3235, 3409), City.VARROCK),
	VARROCK8("Edge", new Position(3236, 3416, 3), new Area(3234, 3416, 3241, 3410), City.VARROCK),
	
	CANIFIS1("Gap", new Position(3505, 3498, 2), new Area(3502, 3499, 3512, 3491), City.CANIFIS),
	CANIFIS2("Gap", new Position(3496, 3504, 2), new Area(3495, 3502, 3505, 3508), City.CANIFIS), 
	CANIFIS3("Gap", new Position(3485, 3499, 2), new Area(3484, 3496, 3494, 3507), City.CANIFIS),
	CANIFIS4("Gap", new Position(3478, 3491, 3), new Area(3481, 3491, 3470, 3501), City.CANIFIS),
	CANIFIS5("Pole-vault", new Position(3480, 3483, 2), new Area(3476, 3480, 3485, 3488), City.CANIFIS),
	CANIFIS6("Gap", new Position(3503, 3476, 3), new Area(3485, 3467, 3505, 3481), City.CANIFIS),
	CANIFIS7("Gap", new Position(3510, 3483, 2), new Area(3507, 3484, 3518, 3473), City.CANIFIS),
	
	FALADOR1("Tightrope", new Position(3040, 3343, 3), new Area(3040, 3343, 3034, 3341), City.FALADOR),
	FALADOR2("Hand holds", new Position(3050, 3350, 3), new Area(3044, 3340, 3053, 3350), City.FALADOR),
	FALADOR3("Gap", new Position(3048, 3359, 3), new Area(3048, 3356, 3052, 3359), City.FALADOR),
	FALADOR4("Gap", new Position(3044, 3361, 3), new Area(3045, 3361, 3050, 3368), City.FALADOR),
	FALADOR5("Tightrope", new Position(3034, 3361, 3), new Area(3034, 3359, 3043, 3366), City.FALADOR),
	FALADOR6("Tightrope", new Position(3026, 3353, 3), new Area(3030, 3351, 3025, 3357), City.FALADOR),
	FALADOR7("Gap", new Position(3016, 3352, 3), new Area(3021, 3353, 3009, 3360), City.FALADOR),
	FALADOR8("Ledge", new Position(3015, 3345, 3), new Area(3016, 3343, 3022, 3350), City.FALADOR),
	FALADOR9("Ledge", new Position(3011, 3343, 3), new Area(3015, 3349, 3009, 3343), City.FALADOR),
	FALADOR10("Ledge", new Position(3012, 3334, 3), new Area(3008, 3342, 3015, 3336), City.FALADOR),
	FALADOR11("Ledge", new Position(3018, 3332, 3), new Area(3011, 3334, 3018, 3330), City.FALADOR),
	FALADOR12("Edge", new Position(3025, 3332, 3), new Area(3024, 3332, 3019, 3335), City.FALADOR),
	
	CAMELOT1("Gap", new Position(2720, 3492, 3), new Area(2731, 3489, 2721, 3498), City.SEERS),
	CAMELOT2("Tightrope", new Position(2710, 3489, 2), new Area(2704, 3498, 2715, 3488), City.SEERS),
	CAMELOT3("Gap", new Position(2710, 3476, 2), new Area(2716, 3476, 2708, 3483), City.SEERS),
	CAMELOT4("Gap", new Position(2700, 3469, 3), new Area(2716, 3475, 2698, 3469), City.SEERS),
	CAMELOT5("Edge", new Position(2703, 3461, 2), new Area(2696, 3459, 2703, 3466), City.SEERS),
	CAMELOT_DEBUG("Ladder", new Position(2728 , 3491, 1), new Area(2730, 3497, 2721, 3490), City.SEERS),
	
	POLL1("Basket", new Position(3351, 2962, 0), new Area(3357, 2967, 3343, 2957), City.POLLNIVEACH),
	POLL2("Market stall", new Position(3349, 2970, 1), new Area(3351, 2968, 3346, 2963), City.POLLNIVEACH),
	POLL3("Banner", new Position(3356, 2978, 1), new Area(3355, 2976, 3352, 2973), City.POLLNIVEACH),
	POLL4("Gap", new Position(3363, 2976, 1), new Area(3362, 2979, 3360, 2977), City.POLLNIVEACH),
	POLL5("Tree", new Position(3367, 2977, 1), new Area(3369, 2976, 3366, 2974), City.POLLNIVEACH),
	POLL6("Rough wall", new Position(3365, 2982, 1), new Area(3369, 2986, 3365, 2982), City.POLLNIVEACH), 
	POLL7("Monkeybars", new Position(3358, 2985, 2), new Area(3365, 2985, 3353, 2983), City.POLLNIVEACH),
	POLL8("Tree", new Position(3359, 2996, 2), new Area(3370, 2995, 3357, 2991), City.POLLNIVEACH),
	POLL9("Drying line", new Position(3363, 3000, 2), new Area(3362, 3004, 3356, 3000), City.POLLNIVEACH),
	
	RELLEKKA1("Gap", new Position(2621, 3669, 3), new Area(2626, 3676, 2622, 3672), City.RELLEKKA),
	RELLEKKA2("Tightrope", new Position(2623, 3658, 3), new Area(2622, 3668, 2615, 3658), City.RELLEKKA),
	RELLEKKA3("Gap", new Position(2629, 3656, 3), new Area(2630, 3655, 2626, 3651), City.RELLEKKA),
	RELLEKKA4("Gap", new Position(2643, 3654, 3), new Area(2644, 3653, 2639, 3649), City.RELLEKKA),
	RELLEKKA5("Tightrope", new Position(2647, 3663, 3), new Area(2650, 3662, 2643, 2657), City.RELLEKKA),
	RELLEKKA6("Pile of fish", new Position(2654, 3676, 3), new Area(2666, 3685, 2655, 3665), City.RELLEKKA),
	
	ARDY1("Gap", new Position(2670, 3310, 3), new Area(2669, 3298, 2673, 3310), City.ARDOUGNE),
	ARDY2("Plank", new Position(2661, 3318, 3), new Area(2666, 3317, 2661, 3319), City.ARDOUGNE),
	ARDY3("Gap", new Position(2653, 3317, 3), new Area(2658, 3316, 2653, 3320), City.ARDOUGNE),
	ARDY4("Gap", new Position(2653, 3308, 3), new Area(2652, 3315, 2654, 3309), City.ARDOUGNE),
	ARDY5("Steel roof", new Position(2654, 3300, 3), new Area(2654, 3299, 2650, 3310), City.ARDOUGNE),
	ARDY6("Gap", new Position(2656, 3296, 3), new Area(2653, 3300, 2658, 3296), City.ARDOUGNE);
	
	private final String name;
	private final Area area;
	private final City city;
	private final Position pos;
	
	private Obstacle(String name, Position pos, Area area, City city) {
		this.name = name;
		this.pos = pos;
		this.area = area.setPlane(pos.getZ());
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	
	public Area getArea() {
		return area;
	}
	
	public Position getPosition() {
		return pos;
	}
	
	public City getCity() {
		return city;
	}
}
