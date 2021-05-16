package kr.co.agramar.demo.api.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import kr.co.agramar.demo.api.domain.Demo;
import kr.co.agramar.demo.api.entity.DemoEntity;
import kr.co.agramar.demo.api.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class DemoQuery implements GraphQLQueryResolver {

	private final DemoRepository demoRepository;

	public Demo demo(Long id) {

		Optional<DemoEntity> demoEntityOptional = demoRepository.findById(id);

		if (demoEntityOptional.isEmpty()) {
			return null;
		}

		DemoEntity demoEntity = demoEntityOptional.get();

		return Demo.builder()
			.id(id)
			.description(demoEntity.getDescription())
			.regDate(demoEntity.getRegDate())
			.build();
	}
}
