package controllers;

import models.*;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

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
}
