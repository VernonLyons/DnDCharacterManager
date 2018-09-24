
CREATE TABLE Ability (
                AbilityId INT AUTO_INCREMENT NOT NULL,
                AbilityName VARCHAR(50) NOT NULL,
                PRIMARY KEY (AbilityId)
);


CREATE TABLE ClassType (
                ClassTypeId INT NOT NULL,
                ClassTypeName VARCHAR(50) NOT NULL,
                Acrobatics INT NOT NULL,
                AnimalHandling INT NOT NULL,
                Arcana INT NOT NULL,
                Athletics INT NOT NULL,
                Deception INT NOT NULL,
                History INT NOT NULL,
                Insight INT NOT NULL,
                Intimidation INT NOT NULL,
                Investigation INT NOT NULL,
                Medicine INT NOT NULL,
                Nature INT NOT NULL,
                Perception INT NOT NULL,
                Performance INT NOT NULL,
                Persuasion INT NOT NULL,
                Religion INT NOT NULL,
                SleightOfHand INT NOT NULL,
                Stealth INT NOT NULL,
                Survival INT NOT NULL,
                PRIMARY KEY (ClassTypeId)
);


CREATE TABLE ClassTypeAbility (
                ClassTypeAbilityId INT AUTO_INCREMENT NOT NULL,
                ClassTypeId INT NOT NULL,
                AbilityId INT NOT NULL,
                MinLevel INT NOT NULL,
                PRIMARY KEY (ClassTypeAbilityId)
);


CREATE TABLE User (
                UserId INT AUTO_INCREMENT NOT NULL,
                Email VARCHAR(50) NOT NULL,
                UserName VARCHAR(50) NOT NULL,
                PRIMARY KEY (UserId)
);


CREATE TABLE Background (
                BackgroundId INT AUTO_INCREMENT NOT NULL,
                BackgroundName VARCHAR(50) NOT NULL,
                Acrobatics INT NOT NULL,
                AnimalHandling INT NOT NULL,
                Arcana INT NOT NULL,
                Athletics INT NOT NULL,
                Deception INT NOT NULL,
                History INT NOT NULL,
                Insight INT NOT NULL,
                Intimidation INT NOT NULL,
                Investigation INT NOT NULL,
                Medicine INT NOT NULL,
                Nature INT NOT NULL,
                Perception INT NOT NULL,
                Performance INT NOT NULL,
                Persuasion INT NOT NULL,
                Religion INT NOT NULL,
                SleightOfHand INT NOT NULL,
                Stealth INT NOT NULL,
                Survival INT NOT NULL,
                PRIMARY KEY (BackgroundId)
);


CREATE TABLE BackgroundAbility (
                BackgroundAbilityId INT AUTO_INCREMENT NOT NULL,
                BackgroundId INT NOT NULL,
                AbilityId INT NOT NULL,
                PRIMARY KEY (BackgroundAbilityId)
);


CREATE TABLE Spell (
                SpellsId INT NOT NULL,
                SpellsName VARCHAR NOT NULL,
                SpellsDescription VARCHAR(1000) NOT NULL,
                PRIMARY KEY (SpellsId)
);


CREATE TABLE Feat (
                FeatsId INT AUTO_INCREMENT NOT NULL,
                FeatsName VARCHAR(50),
                FeatsDescription VARCHAR(1000),
                PRIMARY KEY (FeatsId)
);


CREATE TABLE Race (
                RaceId INT AUTO_INCREMENT NOT NULL,
                RaceName VARCHAR(50) NOT NULL,
                RaceStrMod INT NOT NULL,
                RaceDexMod INT NOT NULL,
                RaceConMod INT NOT NULL,
                RaceIntMod INT NOT NULL,
                RaceWisMod INT NOT NULL,
                RaceChaMod INT NOT NULL,
                Acrobatics INT NOT NULL,
                AnimalHandling INT NOT NULL,
                Arcana INT NOT NULL,
                Athletics INT NOT NULL,
                Deception INT NOT NULL,
                History INT NOT NULL,
                Insight INT NOT NULL,
                Intimidation INT NOT NULL,
                Investigation INT NOT NULL,
                Medicine INT NOT NULL,
                Nature INT NOT NULL,
                Perception INT NOT NULL,
                Performance INT NOT NULL,
                Persuasion INT NOT NULL,
                Religion INT NOT NULL,
                SleightOfHand INT NOT NULL,
                Stealth INT NOT NULL,
                Survival INT NOT NULL,
                PRIMARY KEY (RaceId)
);


CREATE TABLE RaceAbility (
                RaceAbilityId INT NOT NULL,
                RaceId INT NOT NULL,
                AbilityId INT NOT NULL,
                PRIMARY KEY (RaceAbilityId)
);


CREATE TABLE Character_1 (
                CharacterId INT AUTO_INCREMENT NOT NULL,
                CharacterName VARCHAR(50) NOT NULL,
                Level INT AUTO_INCREMENT NOT NULL,
                Strength INT NOT NULL,
                Dexterity INT NOT NULL,
                Constitution INT NOT NULL,
                Intelligence INT NOT NULL,
                Wisdom INT NOT NULL,
                Charisma INT NOT NULL,
                RaceId INT NOT NULL,
                BackgroundId INT NOT NULL,
                HitDice VARCHAR(50) NOT NULL,
                ClassTypeId INT NOT NULL,
                UserId INT NOT NULL,
                Acrobatics INT NOT NULL,
                AnimalHandling INT NOT NULL,
                Arcana INT NOT NULL,
                Athletics INT NOT NULL,
                Deception INT NOT NULL,
                History INT NOT NULL,
                Insight INT NOT NULL,
                Intimidation INT NOT NULL,
                Investigation INT NOT NULL,
                Medicine INT NOT NULL,
                Nature INT NOT NULL,
                Perception INT NOT NULL,
                Performance INT NOT NULL,
                Persuasion INT NOT NULL,
                Religion INT NOT NULL,
                SleightOfHand INT NOT NULL,
                Stealth INT NOT NULL,
                Survival INT NOT NULL,
                PRIMARY KEY (CharacterId)
);


CREATE TABLE FeatsList (
                FeatsListId INT AUTO_INCREMENT NOT NULL,
                FeatsId INT NOT NULL,
                CharacterId INT NOT NULL,
                PRIMARY KEY (FeatsListId)
);


CREATE TABLE SpellsList (
                SpellsListId INT AUTO_INCREMENT NOT NULL,
                SpellsId INT NOT NULL,
                CharacterId INT NOT NULL,
                PRIMARY KEY (SpellsListId)
);


ALTER TABLE RaceAbility ADD CONSTRAINT ability_raceability_fk
FOREIGN KEY (AbilityId)
REFERENCES Ability (AbilityId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE ClassTypeAbility ADD CONSTRAINT ability_classtypeability_fk
FOREIGN KEY (AbilityId)
REFERENCES Ability (AbilityId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE BackgroundAbility ADD CONSTRAINT ability_backgroundability_fk
FOREIGN KEY (AbilityId)
REFERENCES Ability (AbilityId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Character_1 ADD CONSTRAINT classtype_character_fk
FOREIGN KEY (ClassTypeId)
REFERENCES ClassType (ClassTypeId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE ClassTypeAbility ADD CONSTRAINT classtype_classtypeability_fk
FOREIGN KEY (ClassTypeId)
REFERENCES ClassType (ClassTypeId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Character_1 ADD CONSTRAINT user_character_fk
FOREIGN KEY (UserId)
REFERENCES User (UserId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Character_1 ADD CONSTRAINT background_character_fk
FOREIGN KEY (BackgroundId)
REFERENCES Background (BackgroundId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE BackgroundAbility ADD CONSTRAINT background_backgroundability_fk
FOREIGN KEY (BackgroundId)
REFERENCES Background (BackgroundId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE SpellsList ADD CONSTRAINT spells_spellslist_fk
FOREIGN KEY (SpellsId)
REFERENCES Spell (SpellsId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE FeatsList ADD CONSTRAINT feats_featslist_fk
FOREIGN KEY (FeatsId)
REFERENCES Feat (FeatsId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Character_1 ADD CONSTRAINT race_character_fk
FOREIGN KEY (RaceId)
REFERENCES Race (RaceId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE RaceAbility ADD CONSTRAINT race_raceability_fk
FOREIGN KEY (RaceId)
REFERENCES Race (RaceId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE SpellsList ADD CONSTRAINT character_spellslist_fk
FOREIGN KEY (CharacterId)
REFERENCES Character_1 (CharacterId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE FeatsList ADD CONSTRAINT character_featslist_fk
FOREIGN KEY (CharacterId)
REFERENCES Character_1 (CharacterId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
