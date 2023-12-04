package pokemonmaster.cards.Base.ExtraStarters;

import com.megacrit.cardcrawl.actions.watcher.WallopAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Skiddo extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Skiddo",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 2;

    private static final int UPG_DAMAGE = 2;

    public Skiddo() {
        super(cardInfo,new Gogoat(), new Gogoat(),CustomTags.GRASS);
        setDamage(DAMAGE,UPG_DAMAGE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackGrass.png","pokemonmaster/character/cardback/bg_attackGrass_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new WallopAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Skiddo();
    }
}

