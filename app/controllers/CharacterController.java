package controllers;

import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Int;

import javax.inject.Inject;
import java.util.List;

public class CharacterController extends Controller
{
    private FormFactory formFactory;
    private JPAApi jpaApi;

    @Inject
    public CharacterController (FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional
    public Result getCharacter(int characterId)
    {
        String sql = "SELECT c FROM GameCharacter c WHERE characterId = :characterId";

        GameCharacter gameCharacter = jpaApi.em().createQuery(sql, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();

        return ok(views.html.character.render(gameCharacter));
    }

    @Transactional (readOnly = true)
    public Result getCharacterDetails()
    {
        String sql = "SELECT NEW models.CharacterDetails(c.characterId, c.characterName, c.level, r.raceName, ct.classTypeName, b.backgroundName) " +
                     "FROM GameCharacter c JOIN Race r ON c.raceId = r.raceId " +
                     "LEFT OUTER JOIN ClassType ct ON c.classTypeId = ct.classTypeId " +
                     "LEFT OUTER JOIN Background b ON c.backgroundId = b.backgroundId";

        List<CharacterDetails> characterDetails = jpaApi.em().createQuery(sql, CharacterDetails.class).getResultList();

        return ok(views.html.characterdetails.render(characterDetails));
    }

    @Transactional
    public Result deleteCharacter(int characterId)
    {
        String characterSQL = "SELECT c from GameCharacter c WHERE characterId = :characterId";
        GameCharacter gameCharacter = jpaApi.em().createQuery(characterSQL, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();
        jpaApi.em().remove(gameCharacter);

        return ok("Deleted");
    }

    @Transactional
    public Result getEditCharacter(int characterId)
    {
        String characterSQL = "SELECT c from GameCharacter c WHERE characterId = :characterId";
        GameCharacter gameCharacter = jpaApi.em().createQuery(characterSQL, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();

        String nextCharacterIdSQL = "SELECT NEW models.CharacterId(MIN(characterId)) FROM GameCharacter c WHERE characterId > :characterId";
        CharacterId nextCharacterId = jpaApi.em().createQuery(nextCharacterIdSQL, CharacterId.class).setParameter("characterId", characterId).getSingleResult();

        if (nextCharacterId.getId() == null)
        {
            String minCharacterIdSQL = "SELECT NEW models.CharacterId(MIN(characterId)) FROM GameCharacter c";
            nextCharacterId = jpaApi.em().createQuery(minCharacterIdSQL, CharacterId.class).getSingleResult();
        }

        String previousCharacterIdSQL = "SELECT NEW models.CharacterId(MAX(characterId)) FROM GameCharacter c WHERE characterId < :characterId";
        CharacterId previousCharacterId = jpaApi.em().createQuery(previousCharacterIdSQL, CharacterId.class).setParameter("characterId", characterId).getSingleResult();

        if (previousCharacterId.getId() == null)
        {
            String maxCharacterIdSQL = "SELECT NEW models.CharacterId(MAX(characterId)) FROM GameCharacter c";
            previousCharacterId = jpaApi.em().createQuery(maxCharacterIdSQL, CharacterId.class).getSingleResult();
        }

        String raceSQL = "SELECT r FROM Race r ORDER BY raceName";
        List<Race> races = jpaApi.em().createQuery(raceSQL, Race.class).getResultList();

        String classSQL = "SELECT ct FROM ClassType ct ORDER BY classTypeName";
        List<ClassType> classTypes = jpaApi.em().createQuery(classSQL, ClassType.class).getResultList();

        String backgroundSQL = "SELECT b FROM Background b ORDER BY backgroundName";
        List<Background> backgrounds = jpaApi.em().createQuery(backgroundSQL, Background.class).getResultList();

        return ok(views.html.editcharacter.render(gameCharacter, races, classTypes, backgrounds, previousCharacterId.getId(), nextCharacterId.getId()));
    }

    @Transactional
    public Result postEditCharacter(int characterId)
    {
        String characterSQL = "SELECT c FROM GameCharacter WHERE characterId = :characterId";
        GameCharacter gameCharacter = jpaApi.em().createQuery(characterSQL, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();
        String characterName = form.get("characterName");
        int level = Integer.parseInt(form.get("level"));
        int raceId = Integer.parseInt(form.get("raceId"));
        int classTypeId = Integer.parseInt(form.get("classTypeId"));
        int hitDice = Integer.parseInt(form.get("hitDice"));
        int backgroundId = Integer.parseInt(form.get("backgroundId"));
        int strength = Integer.parseInt(form.get("strength"));
        int dexterity = Integer.parseInt(form.get("dexterity"));
        int constitution = Integer.parseInt(form.get("constitution"));
        int intelligence = Integer.parseInt(form.get("intelligence"));
        int wisdom = Integer.parseInt(form.get("wisdom"));
        int charisma = Integer.parseInt(form.get("charisma"));
        String acrobaticsCheck = form.get("acrobatics");
        int acrobatics;
            if (acrobaticsCheck == null)
            {
                acrobatics = 0;
            }
            else
            {
                acrobatics = 1;
            }
        String animalHandlingCheck = form.get("animalHandling");
        int animalHandling;
        if (animalHandlingCheck == null)
        {
            animalHandling = 0;
        }
        else
        {
            animalHandling = 1;
        }
        String arcanaCheck = form.get("arcana");
        int arcana;
        if (arcanaCheck == null)
        {
            arcana = 0;
        }
        else
        {
            arcana = 1;
        }
        String athleticsCheck = form.get("athletics");
        int athletics;
        if (athleticsCheck== null)
        {
            athletics = 0;
        }
        else
        {
            athletics = 1;
        }
        String deceptionCheck = form.get("deception");
        int deception;
        if (deceptionCheck == null)
        {
            deception = 0;
        }
        else
        {
            deception = 1;
        }
        String historyCheck = form.get("history");
        int history;
        if (historyCheck == null)
        {
            history = 0;
        }
        else
        {
            history = 1;
        }
        String insightCheck = form.get("insight");
        int insight;
        if (insightCheck == null)
        {
            insight = 0;
        }
        else
        {
            insight = 1;
        }
        String intimidationCheck = form.get("intimidation");
        int intimidation;
        if (intimidationCheck == null)
        {
            intimidation = 0;
        }
        else
        {
            intimidation = 1;
        }
        String investigationCheck = form.get("investigation");
        int investigation;
        if (investigationCheck == null)
        {
            investigation = 0;
        }
        else
        {
            investigation = 1;
        }
        String medicineCheck = form.get("medicine");
        int medicine;
        if (medicineCheck == null)
        {
            medicine = 0;
        }
        else
        {
            medicine = 1;
        }
        String natureCheck = form.get("nature");
        int nature;
        if (natureCheck == null)
        {
            nature = 0;
        }
        else
        {
            nature = 1;
        }
        String perceptionCheck = form.get("perception");
        int perception;
        if (perceptionCheck == null)
        {
            perception = 0;
        }
        else
        {
            perception = 1;
        }
        String performanceCheck = form.get("performance");
        int performance;
        if (performanceCheck == null)
        {
            performance = 0;
        }
        else
        {
            performance = 1;
        }
        String persuasionCheck = form.get("persuasion");
        int persuasion;
        if (persuasionCheck == null)
        {
            persuasion = 0;
        }
        else
        {
            persuasion = 1;
        }
        String religionCheck = form.get("religion");
        int religion;
        if (religionCheck == null)
        {
            religion = 0;
        }
        else
        {
            religion = 1;
        }
        String sleightOfHandCheck = form.get("sleightOfHand");
        int sleightOfHand;
        if (sleightOfHandCheck == null)
        {
            sleightOfHand = 0;
        }
        else
        {
            sleightOfHand = 1;
        }
        String stealthCheck = form.get("stealth");
        int stealth;
        if (stealthCheck == null)
        {
            stealth = 0;
        }
        else
        {
            stealth = 1;
        }
        String survivalCheck = form.get("survival");
        int survival;
        if (survivalCheck == null)
        {
            survival = 0;
        }
        else
        {
            survival = 1;
        }

        gameCharacter.setCharacterName(characterName);
        gameCharacter.setLevel(level);
        gameCharacter.setRaceId(raceId);
        gameCharacter.setClassTypeId(classTypeId);
        gameCharacter.setHitDice(hitDice);
        gameCharacter.setBackgroundId(backgroundId);
        gameCharacter.setStrength(strength);
        gameCharacter.setDexterity(dexterity);
        gameCharacter.setConstitution(constitution);
        gameCharacter.setIntelligence(intelligence);
        gameCharacter.setWisdom(wisdom);
        gameCharacter.setCharisma(charisma);
        gameCharacter.setAcrobatics(acrobatics);
        gameCharacter.setAnimalHandling(animalHandling);
        gameCharacter.setArcana(arcana);
        gameCharacter.setAthletics(athletics);
        gameCharacter.setDeception(deception);
        gameCharacter.setHistory(history);
        gameCharacter.setInsight(insight);
        gameCharacter.setIntimidation(intimidation);
        gameCharacter.setInvestigation(investigation);
        gameCharacter.setMedicine(medicine);
        gameCharacter.setNature(nature);
        gameCharacter.setPerception(perception);
        gameCharacter.setPerformance(performance);
        gameCharacter.setPersuasion(persuasion);
        gameCharacter.setReligion(religion);
        gameCharacter.setSleightOfHand(sleightOfHand);
        gameCharacter.setStealth(stealth);
        gameCharacter.setSurvival(survival);

        return ok("Saved");
    }
}
