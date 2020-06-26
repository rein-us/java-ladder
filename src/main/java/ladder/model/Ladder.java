package ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int ZERO_HEIGHT = 0;

    private final List<LadderLine> lines;

    private Ladder(List<LadderLine> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(final List<LadderLine> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 라인은 하나 이상이어야 합니다.");
        }
    }

    public static Ladder create(int memberCount, int ladderHeight) {
        List<LadderLine> lines = IntStream.range(ZERO_HEIGHT, ladderHeight)
                .mapToObj(i -> LadderLine.create(memberCount))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public List<LadderLine> getLines() {
        return lines;
    }
}