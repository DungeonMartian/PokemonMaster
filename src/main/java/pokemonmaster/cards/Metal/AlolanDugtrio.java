package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class AlolanDugtrio extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AlolanDugtrio",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 3;



    public AlolanDugtrio() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);
        purgeOnUse = true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }



    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int count = AbstractDungeon.player.hand.size();
        {
            addToTop(new DiscardAction(AbstractDungeon.player, AbstractDungeon.player, count, true));
            for (int i = 1; i <= count-1; i++) {
                addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

            }
            if (upgraded) {
                AbstractCard s = (new AlolanDiglet()).makeCopy();
                s.upgrade();
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(s, 1, false, true));
            }
            else {
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new AlolanDiglet(), 1, false, true));
            }
        }
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new AlolanDugtrio();
    }
}

