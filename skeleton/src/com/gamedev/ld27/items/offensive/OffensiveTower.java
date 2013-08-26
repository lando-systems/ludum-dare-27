package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.modifiers.Mushroom;


public class OffensiveTower extends BaseItem {
	
	public OffensiveTower() {
		super("Offensive Tower", "This tower is really offensive");
		
		this.setIcon(Assets.offensiveTower);
		setDefeats(GameSettings.DefensiveTower);
		setAutoPickup(false);
		_walkable = true;
		_time = 10f;
	}
	
	@Override
	public void use(){
		if (Game.gameWorld.SameTile(Game.player.getUsePosition(), Game.defensiveTower.getPosition())){
			//TODO fix this dialog
			Game.dialogBox.AppendText("Thank you for the shrubbery");
			Game.itemsBar.Remove(this);
			Game.defensiveTower.Alive = false;
			playUseSound();
		}
	}
	
	private float _time;
	
	public void update(float delta) {
		if (isInWorld()) {
			if (Game.player.isWearingHelf()) setAutoPickup(true);
			if (inRange()){
				_time += delta;

				if (_time > 10f) {
					generateInsult();
					_time = 0;
				}
			}
		}
	}
	
	private boolean inRange(){
		return pos.dst2(Game.player.pos) < (320 * 320);
	}
	
	private static final String _insultList[] = new String[] {
		"Your momma is so fat, when she walks past the tv, I miss three shows",
		"Your mother was a hamster and your father smelt of elderberries",
		"Sometimes, your wealth of ignorance astounds me",
		"It looks like your face caught on fire and someone tried to put it out with a hammer",
		"You must have been born on a highway because that's where most accidents happen",	
		"Your birth certificate is an apology letter from the condom factory",	
		"Do you wanna lose ten pounds of ugly fat? Cut off your head",
		"Your family tree must be a cactus because everybody on it is a prick",	
		"I don't exactly hate you, but if you were on fire and I had water, I'd drink it",	
		"So, a thought crossed your mind? Must have been a long and lonely journey",	
		"I'd like to see things from your point of view but I can't seem to get my head that far up my ass",	
		"Shut up, you'll never be the man your mother is",	
		"If assholes could fly, this place would be an airport!",
		"Hey, you have somthing on your chin... no, the 3rd one down",	
		"You are proof that God has a sense of humor",	
		"It's better to let someone think you are an Idiot than to open your mouth and prove it",	
		"Why don't you slip into something more comfortable -- like a coma",	
		"Well I could agree with you, but then we'd both be wrong",	
		"Shock me, say something intelligent",	
		"You do realize makeup isn't going to fix your stupidity?",
		"Am I getting smart with you? How would you know?",	
		"Are you always an idiot, or just when I'm around?",	
		"You are proof that evolution CAN go in reverse",	
		"Do you still love nature, despite what it did to you?",	
		"I've seen people like you, but I had to pay admission!",	
		"Ordinarily people live and learn. You just live",	
		"Jesus loves you, everyone else thinks you're an asshole!",
		"Looks like you traded in your neck for an extra chin!",	
		"I love what you've done with your hair. How do you get it to come out of the nostrils like that?",	
		"Don't you need a license to be that ugly?",	
		"Maybe if you ate some of that makeup you could be pretty on the inside",	
		"You are so stupid, you'd trip over a cordless phone",	
		"You are so old, your birth-certificate expired",	
		"You occasionally stumble over the truth, but you quickly pick yourself up and carry on as if nothing happened",	
		"If a crackhead saw you, he'd think he needs to go on a diet",	
		"You may not be the best looking girl here, but beauty is only a light switch away!",	
		"Nice tan, orange is my favorite color",	
		"Being around you is like having a cancer of the soul",	
		"Learn from your parents' mistakes - use birth control!",	
		"I may be fat, but you're ugly, and I can lose weight",	
		"When was the last time you could see your whole body in the mirror?",
		"You're as useless as a screen door on a submarine",	
		"Don't feel sad, don't feel blue, Frankenstein was ugly too",	
		"You are so old, you fart dust",	
		"Aww, it's so cute when you try to talk about things you don't understand",	
		"Come again when you can't stay quite so long",	
		"If what you don't know can't hurt you, you're invulnerable",	
		"I'd like to help you out. Which way did you come in?",	
		"If you had another brain, it would be lonely",	
		"100,000 sperm, you were the fastest?",	
		"Oh my God, look at you. Was anyone else hurt in the accident?",
		"Roses are red violets are blue, God made me pretty, what happened to you?",	
		"I thought of you all day today. I was at the zoo",	
		"You look like a before picture",	
		"You so ugly when who were born the doctor threw you out the window and the window threw you back!",	
		"I heard you took an IQ test and they said you're results were negative",	
		"You act like your arrogance is a virtue",	
		"Your parents hated you so much you bath toys were an iron and a toaster",	
		"We all sprang from apes, but you didn't spring far enough",	
		"You must think you're strong, but you only smell strong",	
		"Ever since I saw you in your family tree, I've wanted to cut it down",	
		"You'll make a great first wife some day",	
		"I don't know what makes you so stupid, but it really works!",
		"If I want your opinion, I'll give it to you",	
		"The best part of you is still running down your old mans leg",	
		"Even if you were twice as smart, you'd still be stupid!",	
		"Yeah you're pretty... pretty stupid",	
		"If I were to slap you, it would be considered animal abuse!",	
		"What are you doing here? Did someone leave your cage open?",	
		"Brains aren't everything. In your case they're nothing",	
		"I look into your eyes and get the feeling someone else is driving",	
		"If you spoke your mind, you'd be speechless"	,
		"You're as useful as an ashtray on a motorcycle",	
		"I'll never forget the first time we met, although I'll keep trying",
		"Beauty is skin deep, but ugly is to the bone",	
		"Just reminding u there is a very fine line between hobby and mental illness",	
		"I wish you no harm, but it would have been much better if you had never lived",	
		"Your mom must have a really loud bark!",	
		"Are your parents siblings?",	
		"Is your name Maple Syrup? It should be, you sap",	
		"You are depriving some poor village of its idiot"	,
		"You are so old, even your memory is in black and white",	
		"For those who never forget a face, you are an exception",	
		"You're the reason why women earn 75 cents to the dollar",	
		"When anorexics see you, they think they need to go on a diet",
		"Your dad's condom is a bigger than your personality",	
		"So you've changed your mind, does this one work any better?",
		"I hear the only place you're ever invited is outside",	
		"People like you are the reason I work out",	
		"Please tell me you don't home-school your kids"
	};
	
	private void generateInsult() {
		int index = Config.rand.nextInt(_insultList.length);
		Game.dialogBox.SetText("<Offensive Tower> " + _insultList[index]);
	}
}