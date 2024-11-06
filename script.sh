chmod -R 777 lab0 2>/dev/null
rm -rf lab0 2>/dev/null

#1
mkdir lab0
cd lab0
mkdir cubchoo4
cd cubchoo4
touch buneary
echo Способности Defence Curl Foresight Pound Splash Endure >> buneary
echo Frustration Quick Attack Jump Kick Baton Pass Agility Dizzy Punch >> buneary
echo After You Charm Entrainment Bonuce Healing Wish >> buneary
mkdir golem
mkdir jellicent
cd ..
echo '''Живет
Cave Freshwater Mountain''' > dragonite6
mkdir mantine6
cd mantine6
mkdir trubbish
echo '''Ходы Avalanche Body Slam Counter
Covet Defence Curl Double-Edge Dynamicpunch Fake Tears Fire Punch
Focus Punch Fury Cutter Gunk Shot Ice Punch Last Resort Low Kick Mega
Kick Mega Punch Metronome Mud-Slap Rollout Seed Bomb Seismic Toss
Sleep Talk Snore Superpower Swift Thunderpunch''' > ursaring
mkdir ninetales
mkdir haxorus
echo '''Способности Mountain Peak Unbreakable Sturdy Rock
Head''' > shieldon
cd ..
echo weight=44.1 height=31.0 atk=6 def=7 > nidorina4
echo '''satk=6
sdef=8 spd=3''' > parasect0
mkdir zebstrika2
cd zebstrika2
mkdir haxorus
mkdir scrafty
mkdir tangrowth
mkdir cyndaquil
cd ..

#2
chmod 511 cubchoo4
chmod 664 cubchoo4/buneary
chmod u=rx cubchoo4/golem
chmod g=x cubchoo4/golem
chmod o=w cubchoo4/golem
chmod 771 cubchoo4/jellicent
chmod u-w dragonite6
chmod go-r dragonite6
chmod u=rwx mantine6
chmod go=wx mantine6
chmod 577 mantine6/trubbish
chmod 444 mantine6/ursaring
chmod 373 mantine6/ninetales
chmod 750 mantine6/haxorus
chmod 444 mantine6/shieldon
chmod 064 nidorina4
chmod u-rw parasect0
chmod g-r parasect0
chmod o+w parasect0
chmod 511 zebstrika2
chmod 777 zebstrika2/haxorus
chmod 337 zebstrika2/scrafty
chmod 733 zebstrika2/tangrowth
chmod 733 zebstrika2/cyndaquil

#3
ln -s mantine6 Copy_7

chmod u+r zebstrika2/scrafty
cp -Ra zebstrika2 zebstrika2/haxorus
chmod u-r zebstrika2/scrafty zebstrika2/haxorus/zebstrika2/scrafty

chmod u+r parasect0
cat parasect0 > mantine6/ursaringparasect

chmod u+w mantine6/trubbish
cp -a parasect0 mantine6/trubbish
chmod u-w mantine6/trubbish
chmod u-r parasect0

cat mantine6/shieldon mantine6/shieldon > parasect0_88

cd mantine6
ln -s ../dragonite6 shieldondragonite
cd ..

chmod u+w cubchoo4
ln dragonite6 cubchoo4/bunearyondragonite
chmod u-w cubchoo4

#4
#4.1
wc -l cubchoo4/buneary mantine6/ursaring > /tmp/lab1_4.1 2>/dev/null
#4.2
echo '4.2'
grep -rl 'ha' 2>/tmp/errors4.2 | xargs ls -ltr | tail -n 3
#альтернатива
#ls -ltr $(grep -rl 'ha' 2>/tmp/errors4.2) | tail -n 3
#4.3 - ??????????????????
echo '4.3'
ls -R | grep '^-' | grep '4$' | xargs cat | sort -r
#альтернатива
#cat $(ls -R | grep '^-' | grep '4$') | sort -r
#4.4
ls -Rrtl 2>/dev/null | grep '^-' | grep 'h$' | tail -n 3
#4.5
echo '4.5'
ls -Rl 2>&1 | grep '^-' | grep 'y$' | sort -k 2 | tail -n 3
#4.6
echo '4.6'
ls -Rlt cubchoo4/ | grep '^-'

#5
#chmod u+w dragonite6
#rm dragonite6
#chmod u+w mantine6/ursaring
#rm mantine6/ursaring
# rm mantine6/shieldondragonite
#chmod u+w cubchoo4
#rm cubchoo4/bunearyondragonite
#в следующем пункте просят удалить директорию lab0/zebstrika2/scrafty, поэтому здесь удалю копию директории zebstrika2
#chmod -R u=rwx zebstrika2/haxorus/zebstrika2
#rm -rf zebstrika2/haxorus/zebstrika2
chmod u+w zebstrika2
#rmdir zebstrika2/scrafty
chmod u-w zebstrika2



