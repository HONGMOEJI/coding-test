def solution(ineq, eq, n, m):
    return int(eval(f"{n}{ineq}{'=' if eq=='=' else ''}{m}"))