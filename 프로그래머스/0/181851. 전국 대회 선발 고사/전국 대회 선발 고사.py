'''
참석 가능한 학생을 고르고, 오름차순 정렬을 하고, 상위 3명을 선택..
'''
def solution(rank, attendance):
    # 참석 가능한 선발자 인덱스 추출
    candidates = [i for i, attend in enumerate(attendance) if attend]
    
    # rank에 따른 정렬
    candidates.sort(key = lambda x: rank[x])
    
    a, b, c = candidates[:3]
    
    return 10000 * a + 100 * b + c
    