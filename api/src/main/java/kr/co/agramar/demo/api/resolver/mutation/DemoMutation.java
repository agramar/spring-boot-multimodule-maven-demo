package kr.co.agramar.demo.api.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import kr.co.agramar.demo.api.model.domain.Demo;
import kr.co.agramar.demo.api.model.domain.input.DemoInput;
import kr.co.agramar.demo.core.entity.jpa.DemoEntity;
import kr.co.agramar.demo.core.repository.jpa.DemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Component
public class DemoMutation implements GraphQLMutationResolver {

	private final DemoRepository demoRepository;

	public Demo createDemo(DemoInput demoInput) {
		log.info("createDemo : {}", demoInput);

		DemoEntity demoEntity = demoRepository.save(DemoEntity.builder()
			.description(demoInput.getDescription())
			.build());

		return Demo.builder()
			.id(demoEntity.getId())
			.description(demoEntity.getDescription())
			.regDate(demoEntity.getRegDate())
			.build();
	}

	public Demo updateDemo(Long id, String description) {
		log.info("updateDemo : {}, {}", id, description);

		DemoEntity demoEntity = demoRepository.save(DemoEntity.builder()
			.id(id)
			.description(description)
			.regDate(LocalDateTime.now())
			.build());

		return Demo.builder()
			.id(demoEntity.getId())
			.description(demoEntity.getDescription())
			.regDate(demoEntity.getRegDate())
			.build();
	}

}
