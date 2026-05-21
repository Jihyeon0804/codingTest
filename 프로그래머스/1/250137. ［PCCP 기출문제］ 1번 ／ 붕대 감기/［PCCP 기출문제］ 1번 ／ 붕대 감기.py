def solution(bandage, health, attacks):
    time = 0
    curr_health = health

    for attack in attacks:

        gap = attack[0] - time - 1
        curr_health += (gap * bandage[1]) + ((gap // bandage[0]) * bandage[2])

        if curr_health > health:
            curr_health = health

        curr_health -= attack[1]
    
        if curr_health <= 0:
            return -1

        time = attack[0]

    return curr_health