def shift(on_bridge_length, on_bridge_truck):
    on_bridge_length = list(map(lambda x : x -1, on_bridge_length))
    if on_bridge_length[0] == 0:
        on_bridge_length.pop(0)
        on_bridge_truck.pop(0)
    return on_bridge_length

def solution(bridge_length, weight, truck_weights):
    on_bridge_length = []
    on_bridge_truck = []
    time = 0
    while len(on_bridge_length)!=0 or len(truck_weights) !=0:
        if len(truck_weights)>0:
            if sum(on_bridge_truck) + truck_weights[0] > weight:
                on_bridge_length = shift(on_bridge_length, on_bridge_truck)
                time+=1
                continue
            else: 
                on_bridge_length.append(bridge_length)
                on_bridge_truck.append(truck_weights.pop(0))
                on_bridge_length = shift(on_bridge_length, on_bridge_truck)
                time +=1
        else: 
                on_bridge_length = shift(on_bridge_length, on_bridge_truck)
                time +=1                            
                
    answer = time+1
    return answer