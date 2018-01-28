def length(l):
    if type(l) == int:
        return "Sorry, integers don't have length"
    elif type(l) == float:
            return "Sorry, float don't have length"
    else:
        return len(l)


print(length(4.0))
